/* Abrir conexao */
       try {
            String dbdriver = "org.postgresql.Driver";
            String dburl = "jdbc:postgresql://localhost:5432/nome_banco";
            String dbuser = "postgres";
            String dbsenha = "postgres";

            // Carrega Driver do Banco de Dados
            Class.forName(dbdriver);

            if (dbuser.length() != 0) // conexão COM usuário e senha
            {
                conexao = DriverManager.getConnection(dburl, dbuser, dbsenha);
            } else // conexão SEM usuário e senha
            {
                conexao = DriverManager.getConnection(dburl);
            }

            return true;

        } catch (Exception e) {
            System.err.println("Erro ao tentar conectar: " + e);
            return false;
        }

/* Salvar */

        try {
            Statement st = XXX.conexao.createStatement();
            int resultado = st.executeUpdate("INSERT INTO XXX VALUES (DEFAULT, XXX-DADOS");
            
        } catch (Exception e) {
            System.out.println("Erro salvar xxx = " +e);
        }
		
		
/* Listar */

        try {
            Statement st = XXX.conexao.createStatement();
            ResultSet resultado = st.executeQuery("SELECT * FROM XXX");
            
            if (resultado.isBeforeFirst()) {
                while (resultado.next()) {
                    txaXXX.append(resultado.getInt("xxx-campo") + " - " +resultado.getString("xxx-campo") + "\n");
                }
            }
        } catch (Exception e) {
            System.out.println("Erro consultar xxx = " +e);
        }
        	
