
const express = require('express');
const router = express.Router();
const app =  require('../model/modelStudent')

/* GET home page. */
router.get('/', app.getAllStudent );

router.get('/add', app.getNextPageAdd);

router.post('/add', app.getAddStudent );

router.get('/delete/:id', app.getDeleteStudent);

router.get('/edit/:id', app.getNextPageEdit);

router.post('/edit', app.getEdit);

module.exports = router;
