const { createPool } = require('mysql');      //use of createpool method

const pool = createPool({
    port: process.env.DB_PORT,     
    host: process.env.DB_HOST,  
    user: process.env.DB_USER,   
    password: process.env.DB_PASS,   
    database: process.env.MYSQL_DB,   
    connectionLimit: 10
});

module.exports = pool;      //pool helps reuse the connection, instead of open&close
