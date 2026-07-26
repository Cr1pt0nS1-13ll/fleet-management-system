import {
    List,
    ListItemButton,
    ListItemText
} from "@mui/material";

function Sidebar() {

    return (
        <List>

            <ListItemButton>
                <ListItemText primary="🏠 Dashboard" />
            </ListItemButton>

            <ListItemButton>
                <ListItemText primary="🚌 Veículos" />
            </ListItemButton>

            <ListItemButton>
                <ListItemText primary="👨 Motoristas" />
            </ListItemButton>

            <ListItemButton>
                <ListItemText primary="🗺️ Mapas" />
            </ListItemButton>

            <ListItemButton>
                <ListItemText primary="📋 Solicitações" />
            </ListItemButton>

            <ListItemButton>
                <ListItemText primary="⚙ Administração" />
            </ListItemButton>

        </List>
    );
}

export default Sidebar;