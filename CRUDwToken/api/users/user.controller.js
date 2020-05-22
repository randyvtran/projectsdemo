
// let's bring in user.service and create a function call "createcreate, getUserByUserId, getUsers, updateUser, deleteUser, getUserByEmail", then export them


const { create, getUserByUserId, getUsers, updateUser, deleteUser, getUserByEmail } = require("./user.service");   
const { genSaltSync, hashSync, compareSync } = require("bcrypt");
//compareSync is use to compare user's password with the DB

//create one method that uses "jsonwebtoken" package
const { sign } = require('jsonwebtoken');


module.exports = {
    //create one controller createUser with 2 param the user will pass into the body
    createUser: (req,res) =>{
        const body = req.body;
        const salt = genSaltSync(10);   
        //passwd encryt technique b4 send to DB, require "npm install bcrypt"
        // we want hass password to be body.password = 'real password' + salt(round =10)
        // hash takes 2 params "password + salt"
        //** Important: make sure the passwrd varchar column is long (50+), because hash string is long

        body.password = hashSync(body.password, salt);  //this passw is hashed
        
        //use user.service and send the body data to query
        create(body, (err, results) =>{     //pass body, (err, results) to user.service
            if(err){
                console.log(err);
                return res.status(500).json({
                    success: 0,
                    message: "Database connection error"
                });
            }
            return res.status(200).json({
                success: 1,
                data: results
            });
        });
    },


    getUserByUserId: (req, res) => {
        const id = req.params.id;
        console.log("user id :" + id);
        getUserByUserId(id, (err, results) => {
            if (err){
                console.log(err);
                return;
            }
            if (!results) {     //if results not found
                return res.json({
                    success: 0,
                    message: "Record not Found"
                });
            }
            return res.json({
                success: 1,
                data: results
            });
        });
    },


    getUsers: (req, res) =>{
        getUsers((err, results) =>{         //call the getUsers from user.service
            if(err){
                console.log(err);
                return;
            }
            return res.json({
                success: 1,
                data: results
            });
        });
    },


    updateUsers: (req, res) => {
        const body = req.body;
        const salt = genSaltSync(10);
        body.password = hashSync(body.password, salt);
        updateUser(body, (err, results) =>{
            if(err){
                console.log(err);
                return;
            }
            return res.json({
                success: 1,
                message: "updated successfully"
            });
        });
    },


    deleteUser: (req, res) => {
        const data = req.body;
        deleteUser(data, (err, results) =>{
            if(err) {
                console.log(err);
                return;
            }
            if (!results){
                return res.json({
                    success: 0,
                    message: "Record Not Found"
                });
            }
            return res.json({
                success: 1,
                message: "User Deleted Successfully"
            });
        });
    },


    login: (req, res) => {
        
        const body = req.body;
        
        getUserByEmail(body.email, (err, results) =>{
            if(err){
                console.log(err);
            }
            if(!results){
                return res.json({
                    success: 0,
                    data: "Invavid email or password"
                });
            }
            // const salt = genSaltSync(10);
            // body.password = hashSync(body.password, salt);
            const result = compareSync(body.password, results.password);
            
            if (result){
                results.password = undefined;
                const jsontoken = sign({ result: results }, "qwe1234", {expiresIn: "1h"});
                //sign method takes 3 parameters: results object, key, expiration
                //you can add key qwe1234 into the .env file

                return res.json({
                    success: 1,
                    message: "login successfully",
                    token: jsontoken
                });
            } else {
                return res.json({
                    success: 0,
                    message: "Invalid email or password"
                });
            }
        });
    }


}