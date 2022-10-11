var mysql = require('mysql');

var con = mysql.createConnection({
  host: "127.0.0.1",
  user: "root",
  password: "0934868974",
  database:"schools"
});
con.connect();
module.exports = con;