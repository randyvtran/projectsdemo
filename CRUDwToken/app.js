require("dotenv").config(); //load .env file to process.env

const express = require('express');

const app = express();

// app.get('/api', (req, res)=>{
//     res.json({
//         success: 1,
//         message: "This is rest api's working"
//     });
// });



const userRouter = require("./api/users/user.router");

app.use(express.json());

app.use("/api/users", userRouter);  //use "userRouter" for /api/users route 

app.listen(process.env.APP_PORT, ()=>{        //use .env file and process.env to call
    console.log("Server is running on port : ", process.env.APP_PORT);
});
