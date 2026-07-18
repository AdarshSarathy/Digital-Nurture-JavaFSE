call npx -y create-vite@latest bloggerapp --template react
call npx -y create-vite@latest ticketbookingapp --template react
call npx -y create-vite@latest eventexamplesapp --template react
call npx -y create-vite@latest officespacerentalapp --template react
call npx -y create-vite@latest cricketapp --template react

cd bloggerapp
call npm install
cd ..

cd ticketbookingapp
call npm install
cd ..

cd eventexamplesapp
call npm install
cd ..

cd officespacerentalapp
call npm install
cd ..

cd cricketapp
call npm install
cd ..
