import MainLayout from "./layouts/MainLayout";
import Login from "./pages/Login";


function App(){

    const token = localStorage.getItem("token");


    if(!token){

        return <Login />;

    }


    return <MainLayout />;

}


export default App;