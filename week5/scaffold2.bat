call npx -y create-vite@latest myfirstreact --template react
call npx -y create-vite@latest StudentApp --template react
call npx -y create-vite@latest scorecalculatorapp --template react
call npx -y create-vite@latest blogapp --template react
call npx -y create-vite@latest cohortstracker --template react

cd myfirstreact
call npm install
cd ..

cd StudentApp
call npm install
cd ..

cd scorecalculatorapp
call npm install
cd ..

cd blogapp
call npm install
cd ..

cd cohortstracker
call npm install
cd ..
