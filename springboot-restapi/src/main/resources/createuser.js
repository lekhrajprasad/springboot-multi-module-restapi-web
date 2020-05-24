use crud
db.users.insert({"username":"John","surname":"doe","email":"john@doe.com","password":"cleartextpass","authorities":["SITE_USER","ADMIN_USER","SUPER_USER"]})
db.users.insert({"username":"John","surname":"doe","email":"john2@doe.com","password":"$2a$12$qB.L7buUPi2RJHZ9fYceQ.XdyEFxjAmiekH9AEkJvh1gLFPGEf9mW","authorities":["SITE_USER","ADMIN_USER","SUPER_USER"]})
db.users.insert({"username":"lekhraj", "surname":"prasad", "email":"lekhraj.prasad@gmail.com","password":"lpras", "authorities":["SUPER_USER","ADMIN_USER","SITE_USER"],"status":"VERIFIED"})
db.users.insert({"username":"alekh", "surname":"prasad", "email":"lekh565@gmail","password":"lpras", "authorities":["SUPER_USER","ADMIN_USER","SITE_USER"],"status":"VERIFIED"})
