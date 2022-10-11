import express from 'express';

import { getUsers, createUsers, detailUser, deleteUsers, updateUsers } from '../controller/users.js'


const router = express.Router();

router.get('/', getUsers)

router.post('/', createUsers)

router.get('/:id', detailUser)

router.delete('/:id', deleteUsers)

router.patch('/:id', updateUsers)

export default router;