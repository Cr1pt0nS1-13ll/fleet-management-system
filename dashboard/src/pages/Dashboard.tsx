import {
    Grid,
    Paper,
    Typography
} from "@mui/material";

function Dashboard() {

    const cards = [
        { titulo: "Veículos Operando", valor: 35 },
        { titulo: "Motoristas em Viagem", valor: 38 },
        { titulo: "Mapas Abertos", valor: 42 },
        { titulo: "Solicitações", valor: 7 }
    ];

    return (

        <>

            <Typography variant="h4" gutterBottom>
                Dashboard Operacional
            </Typography>

            <Typography color="text.secondary" sx={{ mb: 4 }}>
                Bem-vindo ao Fleet Management System.
            </Typography>

            <Grid container spacing={3}>

                {cards.map((card) => (

                    <Grid size={{ xs: 12, sm: 6, md: 3 }} key={card.titulo}>

                        <Paper
                            elevation={3}
                            sx={{
                                padding: 3,
                                borderRadius: 3
                            }}
                        >

                            <Typography variant="subtitle1">

                                {card.titulo}

                            </Typography>

                            <Typography
                                variant="h3"
                                sx={{
                                    mt: 2,
                                    fontWeight: "bold"
                                }}
                            >

                                {card.valor}

                            </Typography>

                        </Paper>

                    </Grid>

                ))}

            </Grid>

        </>

    );

}

export default Dashboard;