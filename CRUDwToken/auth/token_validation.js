const { jwt } = require('jsonwebtoken');

module.exports = {
    checkToken: (req, res, next) => {

        
        let token = req.get("authorization"); //get the token from Authorization header

        if(token) {
            console.log("Token before slice : " + token);
            //remove bearer from string
            token = token.slice(7);
            console.log("Token after sliced :" + token);
            jwt.verify(token, "qwe1234", (err, decoded) => {
                if (err){
                    res.json({
                        success: 0,
                        message: "Invalid Token"
                    });
                } else {
                    req.decoded = decoded;
                    next();
                }
            });

        } else {
            res.json({
                success: 0,
                message: "Access Denied! Invalid Token"
            });
             
        }
    }
}
