import {
    AppBar,
    Toolbar,
    Typography
} from "@mui/material";


function Header(){

    return (

        <AppBar position="fixed">

            <Toolbar>

                <Typography variant="h6">
                    Fleet Management System
                </Typography>

            </Toolbar>

        </AppBar>

    );

}

export default Header;