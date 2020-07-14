# repotransverse

The user can register by hitting the api /signup and his credentials will be saved into the db.
The admin and user need to generate the token by hitting the /token/generate-token api where they have to provide the username and password and the response will be the token.
The user can see its record and have access to /users/id api
The admin can assign the module to user by hitting the /users/id api which will do a patch.
