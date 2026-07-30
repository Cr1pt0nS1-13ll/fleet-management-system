import { useState } from "react";

import { Box, Drawer } from "@mui/material";

import Header from "../components/Header";
import Sidebar from "../components/Sidebar";

import Dashboard from "../pages/Dashboard";
import Vehicles from "../pages/Vehicles";
import Drivers from "../pages/Drivers";
import Maps from "../pages/Maps";
import Requests from "../pages/Requests";
import Administration from "../pages/Administration";

const drawerWidth = 240;

function MainLayout() {

    const [page, setPage] = useState("dashboard");

    function renderPage() {

        switch (page) {

            case "vehicles":
                return <Vehicles />;

            case "drivers":
                return <Drivers />;

            case "maps":
                return <Maps />;

            case "requests":
                return <Requests />;

            case "administration":
                return <Administration />;

            default:
                return <Dashboard />;
        }

    }

    return (

        <Box sx={{ display: "flex" }}>

            <Header />

            <Drawer
                variant="permanent"
                sx={{
                    width: drawerWidth,
                    "& .MuiDrawer-paper": {
                        width: drawerWidth,
                        boxSizing: "border-box",
                        marginTop: "64px"
                    }
                }}
            >

                <Sidebar onChangePage={setPage} />

            </Drawer>

            <Box
                component="main"
                sx={{
                    flexGrow: 1,
                    p: 4,
                    marginTop: "64px",
                    marginLeft: `${drawerWidth}px`
                }}
            >

                {renderPage()}

            </Box>

        </Box>

    );

}

export default MainLayout;