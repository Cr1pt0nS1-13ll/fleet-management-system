import {
    Box,
    Drawer
} from "@mui/material";

import Header from "../components/Header";
import Sidebar from "../components/Sidebar";


const drawerWidth = 240;


function MainLayout(){

    return (

        <Box sx={{display:"flex"}}>

            <Header />


            <Drawer
                variant="permanent"
                sx={{
                    width: drawerWidth,
                    "& .MuiDrawer-paper":{
                        width: drawerWidth,
                        boxSizing:"border-box",
                        marginTop:"64px"
                    }
                }}
            >

                <Sidebar />

            </Drawer>


            <Box
                component="main"
                sx={{
                    flexGrow:1,
                    p:4,
                    marginTop:"64px",
                    marginLeft:`${drawerWidth}px`
                }}
            >

                <h2>
                    Área principal Fleet
                </h2>


            </Box>


        </Box>

    );


}


export default MainLayout;