import express from 'express';
import bodyParser from 'body-parser'
import usersRoutes from './routes/users.js'

const app = express();
const PORT = 4200;

app.use(bodyParser.json());

app.use('/users', usersRoutes);

app.get('/',(req, res) => res.send('hello word'));

app.listen(PORT,() =>console.log(` sever running on port: http//localhost:${PORT}`))