import { List, ListItemButton, ListItemText } from "@mui/material";

type SidebarProps = {
    onChangePage: (page: string) => void;
};

function Sidebar({ onChangePage }: SidebarProps) {

    return (

        <List>

            <ListItemButton onClick={() => onChangePage("dashboard")}>
                <ListItemText primary="🏠 Dashboard" />
            </ListItemButton>

            <ListItemButton onClick={() => onChangePage("vehicles")}>
                <ListItemText primary="🚌 Veículos" />
            </ListItemButton>

            <ListItemButton onClick={() => onChangePage("drivers")}>
                <ListItemText primary="👨 Motoristas" />
            </ListItemButton>

            <ListItemButton onClick={() => onChangePage("maps")}>
                <ListItemText primary="🗺️ Mapas" />
            </ListItemButton>

            <ListItemButton onClick={() => onChangePage("requests")}>
                <ListItemText primary="📋 Solicitações" />
            </ListItemButton>

            <ListItemButton onClick={() => onChangePage("administration")}>
                <ListItemText primary="⚙ Administração" />
            </ListItemButton>

        </List>

    );

}

export default Sidebar;