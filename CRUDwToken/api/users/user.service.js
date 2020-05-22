const pool = require("../../config/database");

module.exports = {
    create: (data, callBack) => {
        pool.query('INSERT INTO registration(firstName, lastName, gender, email, password, number) VALUES(?,?,?,?,?,?)',
        [
            data.first_name,
            data.last_name,
            data.gender,
            data.email,
            data.password,
            data.number

        ],
        //the array above will provide the values to the INSERT cmd.

        //the callback takes 3 parameters: errors, results, fields
        //err: show system error
        //results: show DB data
        //fields: not use
        (error, results, fields) => {
            if(error){
                return callBack(error)     
                //if the error is there, we use the callback as  error
            }
            //else return callback as no error with data
                return callBack(null, results)
        }

        );
    },


    getUsers: callBack => {         // callBack == (req, res)
        pool.query(`SELECT id, firstName, lastName, gender, email, number FROM registration`, [], (error, results, fields) =>{
            if(error) {
                return callBack(error);
            }
            return callBack(null, results);
        });
    },


    getUserByUserId: (id, callBack) => {
        pool.query(`SELECT id, firstName, lastName, gender, email, number FROM registration WHERE id = ?`, [id], (error, results, fields) =>{
            if(error) {
                return callBack(error);
            }
            return callBack(null, results[0]);
        });
    },



    updateUser: (data, callBack) => {
        pool.query('UPDATE registration SET firstName=?, lastName=?, gender=?, email=?, password=?, number=? WHERE id=?',
        [
            data.first_name,
            data.last_name,
            data.gender,
            data.email,
            data.password,
            data.number,
            data.id

        ],
        
        (error, results, fields) => {
            if(error){
                return callBack(error);     
                //if the error is there, we use the callback as  error
            }
            //else return callback as no error with data
                return callBack(null, results[0]);
                //results[0] is first array which have [{id:x, firstName:abc, lastName:xyz..]
        });
    },

    deleteUser: (data, callBack) => {
        pool.query('DELETE FROM registration WHERE id = ?', [data.id], (error, results, fields) => {
        if(error){
            return callBack(error);
        }
        return callBack(null, results[0]);
        //results[0] is first array which have [{id:x, firstName:abc, lastName:xyz..]
    });
},

getUserByEmail: (email, callBack) => {
    pool.query(`SELECT * FROM registration WHERE email = ?`, [email], (error, results, fields) =>{
        if(error) {
            return callBack(error);
        }
        
        return callBack(null, results[0]);  
        //results[0] is first array which have [{id:x, firstName:abc, lastName:xyz..]
    });
}



}
