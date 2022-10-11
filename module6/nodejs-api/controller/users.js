import { v4 as uuidv4 } from 'uuid';

let users = []

export const getUsers = (req, res) => {
    console.log(users);
    res.send(users);
}

export const createUsers = (req, res) => {
    const user = req.body;

    // const userID = uuid();

    // const userWithId = {...user, id: userID};

    users.push({ ...user, id: uuidv4() });

    res.send('Them thanh cong')
}

export const detailUser = (req, res) => {
    const { id } = req.params;

    const foundUser = users.find((user) => user.id == id);

    res.send(foundUser)
}

export const deleteUsers = (req, res) => {
    const { id } = req.params;

    users = users.filter((user) => user.id !== id)

    res.send('Xoa thanh cong')
}

export const updateUsers = (req, res) => {
    const { id } = req.params;
    const { fisrtName, lastName, age } = req.body;

    const user = users.find((user) => user.id == id)

    if (fisrtName) user.fisrtName = fisrtName;
    if (lastName) user.lastName = lastName;
    if (age) user.age = age;

    res.send('update thanh cong')
}