import {
    AppBar,
    Toolbar,
    Typography,
    Button,
    Box
} from "@mui/material";

function Header() {

    // Esta função é executada quando o usuário
    // clicar no botão "Sair".
    function handleLogout() {

        // Remove o JWT salvo no navegador.
        // Sem ele, o usuário deixa de estar autenticado.
        localStorage.removeItem("token");

        // Recarrega a aplicação.
        // Como o token foi removido,
        // o App.tsx exibirá novamente a tela de Login.
        window.location.reload();

    }

    return (

        // Barra superior do sistema.
        <AppBar position="fixed">

            <Toolbar>

                {/* flexGrow faz este título ocupar
                   todo o espaço disponível da Toolbar.
                   Assim o botão fica alinhado à direita. */}
                <Typography
                    variant="h6"
                    sx={{ flexGrow: 1 }}
                >
                    Fleet Management System
                </Typography>

                <Box>

                    {/* Quando clicar,
                       executa handleLogout() */}
                    <Button
                        color="inherit"
                        onClick={handleLogout}
                    >
                        Sair
                    </Button>

                </Box>

            </Toolbar>

        </AppBar>

    );

}

export default Header;