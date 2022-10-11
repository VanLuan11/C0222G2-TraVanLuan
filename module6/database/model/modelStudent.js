const dbConnect = require("../database/connect")

/* GET home page. */
let getAllStudent = async (req, res, next) => {
    dbConnect.query("SELECT * FROM student", function (err, data) {
        if (err) throw err;
        res.render("index", { data: data });

        //   // chuyển từ Json sang object
        //   res.send(JSON.parse(data))

        //   // chuyển từ object sang json
        //   res.send(JSON.stringify(data))
    })
};


//Thêm mới
let getNextPageAdd = async (req, res) => {
    res.render("add")
};

let getAddStudent = async (req, res) => {
    dbConnect.query(`INSERT INTO student (name, age, class) VALUES ('${req.body.name}','${req.body.age}','${req.body.class}')`, function (err) {
        if (err) throw err;
        res.redirect("/")
    })
};

//Xoá
let getDeleteStudent = async (req, res) => {
    dbConnect.query(`DELETE FROM student WHERE id=${req.params.id}`, function (err) {
        if (err) throw err;
        res.redirect("/")
    })
};

//Chỉnh sửa
let getNextPageEdit = async (req, res) => {
    var data = dbConnect.query(`SELECT * FROM student WHERE id=${req.params.id}`, function (err, result) {
        if (err) throw err;
        data = {
            id: result[0].id,
            name: result[0].name,
            age: result[0].age,
            class: result[0].class,
        }
        res.render("edit", { data })
    })
};

let getEdit = async (req, res) => {
    dbConnect.query(`UPDATE student SET name='${req.body.name}',age='${req.body.age}',class='${req.body.class}' WHERE id='${req.body.id}'`, function (err) {
        console.log(req.body);
        if (err) throw err;
        res.redirect("/")
    })
};

module.exports = { getAllStudent, getNextPageAdd, getAddStudent, getDeleteStudent, getNextPageEdit, getEdit};