
import java.awt.CardLayout;
import java.util.LinkedList;
import java.util.Queue;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class proyectoMiTeleferico extends javax.swing.JFrame {
    
    CSCircularTarjeta colaCT;
    PilaRegistroDelDia pilaRDD;
    CSCircularTigoMoney colaCTM;
    PilaSacarTarjetaBol pilaSTB;
    HoraFecha hf;
    
    
    Tarjeta tar;
    TigoMoney tigo;
    RegistroDelDia registroDD;
    Boleto boleto;
    
    CardLayout layout;
    
    public proyectoMiTeleferico() {
        initComponents();
        layout = (CardLayout) pnlCards.getLayout();
        ///------------------
        colaCT = new CSCircularTarjeta();
        pilaRDD = new PilaRegistroDelDia();
        colaCTM = new CSCircularTigoMoney();
        pilaSTB = new PilaSacarTarjetaBol();
        ///-----------------
        tar = new Tarjeta("111","Juan",0);
        colaCT.adicionar(tar);
        tar = new Tarjeta("222","Rosa",10);
        colaCT.adicionar(tar);
        tar = new Tarjeta("333","Carlos",15);
        colaCT.adicionar(tar);
        tar = new Tarjeta("444","Camila",15);
        colaCT.adicionar(tar);
        ///------------------
        tigo = new TigoMoney("111","Juan",800,123,112233);
        colaCTM.adicionar(tigo);
        tigo = new TigoMoney("222","Rosa",500,234,223344);
        colaCTM.adicionar(tigo);
        tigo = new TigoMoney("333","Carlos",600,345,334455);
        colaCTM.adicionar(tigo);
        tigo = new TigoMoney("444","Camila",800,456,445566);
        colaCTM.adicionar(tigo);
        tigo = new TigoMoney("555","Horge",987,567,556677);
        colaCTM.adicionar(tigo);
        tigo = new TigoMoney("600","Jorge",200,678,667788);
        colaCTM.adicionar(tigo);
        tigo = new TigoMoney("777","Jenni",300,789,778899);
        colaCTM.adicionar(tigo);
        tigo = new TigoMoney("888","Frank",305,890,889900);
        colaCTM.adicionar(tigo);
        tigo = new TigoMoney("999","Ivan",1500,901,990011);
        colaCTM.adicionar(tigo);
        
    }
    
    private void llenarTablaTarjeta(CSCircularTarjeta T)
    {   DefaultTableModel model = (DefaultTableModel)tblUDT.getModel();
        model.setRowCount(0);
        CSCircularTarjeta aux = new CSCircularTarjeta() ;
        Object data[] = new Object[5];
        while(!T.esVacia())
        {   Tarjeta dato = null;
            dato = T.eliminar();
            data[0] = dato.getCIT();
            data[1] = dato.getNOMBRET();
            data[2] = dato.getMONTOT();
            model.addRow(data);
            aux.adicionar(dato);
        }
        T.vaciar(aux);
    }
    private void llenarTablaTigoMoney(CSCircularTigoMoney T)
    {   DefaultTableModel model = (DefaultTableModel)tblUDTigo.getModel();
        model.setRowCount(0);
        CSCircularTigoMoney aux = new CSCircularTigoMoney() ;
        Object data[] = new Object[5];
        while(!T.esVacia())
        {   TigoMoney dato = null;
            dato = T.eliminar();
            String c = dato.getNroCelular()+"";
            String m = dato.getMonto()+"Bs";
            data[0] = dato.getCi();
            data[1] = dato.getNombre();
            data[2] = c;
            data[3] = m;
            model.addRow(data);
            aux.adicionar(dato);
        }
        T.vaciar(aux);
    }
    private void llenarTablaSacaBolTar(PilaSacarTarjetaBol T)
    {   DefaultTableModel model = (DefaultTableModel)tblSBT.getModel();
        model.setRowCount(0);
        PilaSacarTarjetaBol aux = new PilaSacarTarjetaBol();
        
        Object data[] = new Object[5];
        while(!T.esVacia())
        {   SacarTarjetaBol dato = null;
            dato = T.eliminar();
            data[0] = dato.getCIR();
            data[1] = dato.getNombreR();
            data[2] = dato.getTipoR();
            data[3] = dato.getFecha();
            data[4] = dato.getHora();
            model.addRow(data);
            aux.adicionar(dato);
        }
        T.vaciar(aux);
    }
    private void llenarTablaRegistroDD(PilaRegistroDelDia T)
    {  DefaultTableModel model = (DefaultTableModel)tblRDD.getModel();
        model.setRowCount(0);
        PilaRegistroDelDia aux = new PilaRegistroDelDia();
        Object data[] = new Object[5];
        while(!T.esVacia())
        {   RegistroDelDia dato = null;
            dato = T.eliminar();
            data[0] = dato.getCIR();
            data[1] = dato.getNombreR();
            data[2] = dato.getTipoR();
            data[3] = dato.getFecha();
            data[4] = dato.getHora();
            model.addRow(data);
            aux.adicionar(dato);
        }
        T.vaciar(aux);
    }
    
    String convertirCosto(int dato)
    {   if(dato != 1)
        {Integer valor = dato*2 + 1;
        String da = valor + "";
        return da;}
        else return "3";
    }
    void llenarFactura(SacarTarjetaBol x)
    {   txtFacturaF.setText(x.getFecha());
        txtFacturaN.setText(x.getNombreR());
        txtFacturaCCC.setText(x.getCIR());
        txtFacturaH.setText(x.getHora());
        String mon = x.getMontoR()+"";
        txtFacturaTotal.setText(mon);
    }
    void llenarTarjeta(SacarTarjetaBol x)
    {   txtTarjetaCIOK.setText(x.getCIR());
        txtTarjetaNombreOK.setText(x.getNombreR());
        txtTarjetaFechaOK.setText(x.getFecha());
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlHeader = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        lblTitle1 = new javax.swing.JLabel();
        pnlMenu = new javax.swing.JPanel();
        pnpMenuTitle = new javax.swing.JPanel();
        lblMenuTitle = new javax.swing.JLabel();
        btnSacaBT = new javax.swing.JButton();
        btnCabinas = new javax.swing.JButton();
        btnSacar = new javax.swing.JButton();
        pnpMenuTitle1 = new javax.swing.JPanel();
        lblMenuTitle1 = new javax.swing.JLabel();
        btnM1 = new javax.swing.JButton();
        btnM3 = new javax.swing.JButton();
        btnM4 = new javax.swing.JButton();
        pnpMenuTitle2 = new javax.swing.JPanel();
        lblMenuTitle2 = new javax.swing.JLabel();
        btnM5 = new javax.swing.JButton();
        pnpMenuTitle3 = new javax.swing.JPanel();
        lblMenuTitle3 = new javax.swing.JLabel();
        btnRTM = new javax.swing.JButton();
        pnlCards = new javax.swing.JPanel();
        pnlPlataformaParaSacarBoletos = new javax.swing.JPanel();
        btnSacarTarjeta = new javax.swing.JButton();
        btnSacarBoleto = new javax.swing.JButton();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        pnlInicio = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        btnBoleto = new javax.swing.JButton();
        bntRecarga = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btnTP = new javax.swing.JButton();
        btnPlataformaMapa = new javax.swing.JButton();
        jLabel60 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        pnlSacaBoleto = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        txtSacaCodigo = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        btnSacaAceptarBole = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        txtSacaCI = new javax.swing.JTextField();
        btnSacaAceptar2 = new javax.swing.JButton();
        jLabel63 = new javax.swing.JLabel();
        pnlSacaTarjeta = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        txtSacaCodigoT = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        btnSacaTarjetaPropia = new javax.swing.JButton();
        jLabel30 = new javax.swing.JLabel();
        txtSacaCIT = new javax.swing.JTextField();
        btnSacaTSalir = new javax.swing.JButton();
        jLabel64 = new javax.swing.JLabel();
        pnlCompraBoleto = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtCiBoleto = new javax.swing.JTextField();
        txtContraseñaBoleto = new javax.swing.JTextField();
        txtCostoBoleto = new javax.swing.JTextField();
        btnAceBol = new javax.swing.JButton();
        btnSalirBol = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        cbxParadas = new javax.swing.JComboBox<>();
        jLabel17 = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        jLabel67 = new javax.swing.JLabel();
        pnlRecargaTarjeta = new javax.swing.JPanel();
        txtContraseñaRTA = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtCiRTA = new javax.swing.JTextField();
        btnAceptarRTA = new javax.swing.JButton();
        btnSalirRecar = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        txtMontoRTA = new javax.swing.JTextField();
        jLabel68 = new javax.swing.JLabel();
        pnlComprarTarjeta = new javax.swing.JPanel();
        txtContraseñaPT = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        txtCIPT = new javax.swing.JTextField();
        btnPT = new javax.swing.JButton();
        btnSalirTar = new javax.swing.JButton();
        jLabel23 = new javax.swing.JLabel();
        txtMontoPT = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        txtSaldoPT = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        jLabel69 = new javax.swing.JLabel();
        pnlMapa = new javax.swing.JPanel();
        btnSalirMapa = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        pnlRegistroDelDia = new javax.swing.JPanel();
        pnlEmpleadosTitle1 = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        btnMostarRDD = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblRDD = new javax.swing.JTable();
        pnlMostrarUsuariosTarjeta = new javax.swing.JPanel();
        pnlEmpleadosTitle2 = new javax.swing.JPanel();
        jLabel32 = new javax.swing.JLabel();
        btnMostrarUDT = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblUDT = new javax.swing.JTable();
        pnlMostrarUsuariosTigoMoney = new javax.swing.JPanel();
        pnlEmpleadosTitle5 = new javax.swing.JPanel();
        jLabel36 = new javax.swing.JLabel();
        btnMostrarUDTigo = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblUDTigo = new javax.swing.JTable();
        pnlMostrarSacarBoletoTarjeta = new javax.swing.JPanel();
        pnlEmpleadosTitle6 = new javax.swing.JPanel();
        jLabel37 = new javax.swing.JLabel();
        btnMostrarSBT = new javax.swing.JButton();
        jScrollPane7 = new javax.swing.JScrollPane();
        tblSBT = new javax.swing.JTable();
        pnlCrearTigoMoney = new javax.swing.JPanel();
        txtCTMN = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        txtCTMCI = new javax.swing.JTextField();
        btnAceptarCTM = new javax.swing.JButton();
        jLabel35 = new javax.swing.JLabel();
        txtCTMM = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        txtCTMCEL = new javax.swing.JTextField();
        txtCTMCSE = new javax.swing.JTextField();
        jLabel39 = new javax.swing.JLabel();
        pnlRecargaCuentaTigoMoney = new javax.swing.JPanel();
        txtRTMContraseña = new javax.swing.JTextField();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        txtRTMCelular = new javax.swing.JTextField();
        btnAceptarRTMoney = new javax.swing.JButton();
        jLabel43 = new javax.swing.JLabel();
        txtTMMonto = new javax.swing.JTextField();
        jLabel65 = new javax.swing.JLabel();
        pnlFacturaBol = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        txtFacturaF = new javax.swing.JTextField();
        txtFacturaH = new javax.swing.JTextField();
        txtFacturaN = new javax.swing.JTextField();
        txtFacturaCCC = new javax.swing.JTextField();
        txtFacturaTotal = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnFacturaListo = new javax.swing.JButton();
        pnlTarjetaPropia = new javax.swing.JPanel();
        btnTarjetaListo = new javax.swing.JButton();
        jLabel59 = new javax.swing.JLabel();
        txtTarjetaNombreOK = new javax.swing.JTextField();
        txtTarjetaCIOK = new javax.swing.JTextField();
        txtTarjetaFechaOK = new javax.swing.JTextField();
        jLabel75 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));
        setResizable(false);

        pnlHeader.setBackground(new java.awt.Color(0, 0, 0));

        lblTitle.setFont(new java.awt.Font("DejaVu Sans", 1, 36)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(255, 255, 255));
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("VENTA INTELIGENTE DE BOLETO");

        lblTitle1.setFont(new java.awt.Font("DejaVu Sans", 1, 36)); // NOI18N
        lblTitle1.setForeground(new java.awt.Color(255, 255, 255));
        lblTitle1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle1.setText("Y RECARGA DE TARJETA ");

        javax.swing.GroupLayout pnlHeaderLayout = new javax.swing.GroupLayout(pnlHeader);
        pnlHeader.setLayout(pnlHeaderLayout);
        pnlHeaderLayout.setHorizontalGroup(
            pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHeaderLayout.createSequentialGroup()
                .addGap(386, 386, 386)
                .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 633, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(380, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlHeaderLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTitle1)
                .addGap(468, 468, 468))
        );
        pnlHeaderLayout.setVerticalGroup(
            pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHeaderLayout.createSequentialGroup()
                .addContainerGap(43, Short.MAX_VALUE)
                .addComponent(lblTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTitle1)
                .addGap(35, 35, 35))
        );

        pnlMenu.setBackground(new java.awt.Color(0, 102, 204));

        pnpMenuTitle.setBackground(new java.awt.Color(0, 0, 0));

        lblMenuTitle.setFont(new java.awt.Font("DejaVu Sans", 1, 18)); // NOI18N
        lblMenuTitle.setForeground(new java.awt.Color(255, 255, 255));
        lblMenuTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMenuTitle.setText("MENU");

        javax.swing.GroupLayout pnpMenuTitleLayout = new javax.swing.GroupLayout(pnpMenuTitle);
        pnpMenuTitle.setLayout(pnpMenuTitleLayout);
        pnpMenuTitleLayout.setHorizontalGroup(
            pnpMenuTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblMenuTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnpMenuTitleLayout.setVerticalGroup(
            pnpMenuTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnpMenuTitleLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblMenuTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnSacaBT.setBackground(new java.awt.Color(102, 255, 255));
        btnSacaBT.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        btnSacaBT.setText("Registro Bol.Tar.");
        btnSacaBT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSacaBTMouseClicked(evt);
            }
        });
        btnSacaBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSacaBTActionPerformed(evt);
            }
        });

        btnCabinas.setBackground(new java.awt.Color(102, 255, 255));
        btnCabinas.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        btnCabinas.setText("COMPRA INTE.");
        btnCabinas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCabinasMouseClicked(evt);
            }
        });
        btnCabinas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCabinasActionPerformed(evt);
            }
        });

        btnSacar.setBackground(new java.awt.Color(102, 255, 255));
        btnSacar.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        btnSacar.setText("SACAR BOL .TAR.");
        btnSacar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSacarMouseClicked(evt);
            }
        });
        btnSacar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSacarActionPerformed(evt);
            }
        });

        pnpMenuTitle1.setBackground(new java.awt.Color(0, 0, 0));

        lblMenuTitle1.setFont(new java.awt.Font("DejaVu Sans", 1, 18)); // NOI18N
        lblMenuTitle1.setForeground(new java.awt.Color(255, 255, 255));
        lblMenuTitle1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMenuTitle1.setText("COMPRA");

        javax.swing.GroupLayout pnpMenuTitle1Layout = new javax.swing.GroupLayout(pnpMenuTitle1);
        pnpMenuTitle1.setLayout(pnpMenuTitle1Layout);
        pnpMenuTitle1Layout.setHorizontalGroup(
            pnpMenuTitle1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnpMenuTitle1Layout.createSequentialGroup()
                .addComponent(lblMenuTitle1, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnpMenuTitle1Layout.setVerticalGroup(
            pnpMenuTitle1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnpMenuTitle1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblMenuTitle1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnM1.setBackground(new java.awt.Color(102, 255, 255));
        btnM1.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        btnM1.setText("REGISTRO DEL DIA");
        btnM1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnM1MouseClicked(evt);
            }
        });
        btnM1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnM1ActionPerformed(evt);
            }
        });

        btnM3.setBackground(new java.awt.Color(102, 255, 255));
        btnM3.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        btnM3.setText("USUARIO TARJETA");
        btnM3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnM3MouseClicked(evt);
            }
        });
        btnM3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnM3ActionPerformed(evt);
            }
        });

        btnM4.setBackground(new java.awt.Color(102, 255, 255));
        btnM4.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        btnM4.setText("USUARIOS TM");
        btnM4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnM4MouseClicked(evt);
            }
        });
        btnM4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnM4ActionPerformed(evt);
            }
        });

        pnpMenuTitle2.setBackground(new java.awt.Color(0, 0, 0));

        lblMenuTitle2.setFont(new java.awt.Font("DejaVu Sans", 1, 18)); // NOI18N
        lblMenuTitle2.setForeground(new java.awt.Color(255, 255, 255));
        lblMenuTitle2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMenuTitle2.setText("TIGOMONEY");

        javax.swing.GroupLayout pnpMenuTitle2Layout = new javax.swing.GroupLayout(pnpMenuTitle2);
        pnpMenuTitle2.setLayout(pnpMenuTitle2Layout);
        pnpMenuTitle2Layout.setHorizontalGroup(
            pnpMenuTitle2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnpMenuTitle2Layout.createSequentialGroup()
                .addComponent(lblMenuTitle2, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        pnpMenuTitle2Layout.setVerticalGroup(
            pnpMenuTitle2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnpMenuTitle2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblMenuTitle2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        btnM5.setBackground(new java.awt.Color(102, 255, 255));
        btnM5.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        btnM5.setText("CREAR CUENTA TM");
        btnM5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnM5MouseClicked(evt);
            }
        });
        btnM5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnM5ActionPerformed(evt);
            }
        });

        pnpMenuTitle3.setBackground(new java.awt.Color(0, 0, 0));

        lblMenuTitle3.setFont(new java.awt.Font("DejaVu Sans", 1, 18)); // NOI18N
        lblMenuTitle3.setForeground(new java.awt.Color(255, 255, 255));
        lblMenuTitle3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMenuTitle3.setText("MOSTRAR");

        javax.swing.GroupLayout pnpMenuTitle3Layout = new javax.swing.GroupLayout(pnpMenuTitle3);
        pnpMenuTitle3.setLayout(pnpMenuTitle3Layout);
        pnpMenuTitle3Layout.setHorizontalGroup(
            pnpMenuTitle3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnpMenuTitle3Layout.createSequentialGroup()
                .addComponent(lblMenuTitle3, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        pnpMenuTitle3Layout.setVerticalGroup(
            pnpMenuTitle3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnpMenuTitle3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblMenuTitle3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnRTM.setBackground(new java.awt.Color(102, 255, 255));
        btnRTM.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        btnRTM.setText("RECARGAR TM");
        btnRTM.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRTMMouseClicked(evt);
            }
        });
        btnRTM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRTMActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlMenuLayout = new javax.swing.GroupLayout(pnlMenu);
        pnlMenu.setLayout(pnlMenuLayout);
        pnlMenuLayout.setHorizontalGroup(
            pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSacaBT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCabinas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnM3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnM4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnM1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnpMenuTitle1, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
                    .addComponent(btnSacar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnpMenuTitle2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnM5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnpMenuTitle3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnpMenuTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnRTM, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlMenuLayout.setVerticalGroup(
            pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMenuLayout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(pnpMenuTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSacar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSacaBT, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(pnpMenuTitle1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCabinas, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(pnpMenuTitle3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnM1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnM3, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(pnpMenuTitle2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnM4, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRTM, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnM5, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlCards.setBackground(new java.awt.Color(0, 0, 0));
        pnlCards.setLayout(new java.awt.CardLayout());

        pnlPlataformaParaSacarBoletos.setBackground(new java.awt.Color(0, 0, 0));
        pnlPlataformaParaSacarBoletos.setLayout(null);

        btnSacarTarjeta.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        btnSacarTarjeta.setText("SACAR TARJETA");
        btnSacarTarjeta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSacarTarjetaMouseClicked(evt);
            }
        });
        pnlPlataformaParaSacarBoletos.add(btnSacarTarjeta);
        btnSacarTarjeta.setBounds(100, 700, 330, 40);

        btnSacarBoleto.setBackground(new java.awt.Color(255, 255, 255));
        btnSacarBoleto.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        btnSacarBoleto.setText("SACAR BOLETO");
        btnSacarBoleto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSacarBoletoMouseClicked(evt);
            }
        });
        pnlPlataformaParaSacarBoletos.add(btnSacarBoleto);
        btnSacarBoleto.setBounds(100, 630, 330, 40);

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setText("MY TELEFERICO");
        pnlPlataformaParaSacarBoletos.add(jLabel27);
        jLabel27.setBounds(780, 10, 403, 74);

        jLabel28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/189.jpg"))); // NOI18N
        pnlPlataformaParaSacarBoletos.add(jLabel28);
        jLabel28.setBounds(0, 20, 1190, 820);

        pnlCards.add(pnlPlataformaParaSacarBoletos, "crdSacarBT");

        pnlInicio.setBackground(new java.awt.Color(0, 0, 0));
        pnlInicio.setLayout(null);

        jPanel1.setBackground(new java.awt.Color(0, 102, 204));

        btnBoleto.setBackground(new java.awt.Color(0, 0, 0));
        btnBoleto.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnBoleto.setForeground(new java.awt.Color(255, 255, 255));
        btnBoleto.setText("COMPRA DE BOLETO INTELIGENTE");
        btnBoleto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBoletoMouseClicked(evt);
            }
        });
        btnBoleto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBoletoActionPerformed(evt);
            }
        });

        bntRecarga.setBackground(new java.awt.Color(0, 0, 0));
        bntRecarga.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        bntRecarga.setForeground(new java.awt.Color(255, 255, 255));
        bntRecarga.setText("RECARGA DE TARJETAS ");
        bntRecarga.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bntRecargaMouseClicked(evt);
            }
        });
        bntRecarga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntRecargaActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel2.setText("Compra Inteligente");

        btnTP.setBackground(new java.awt.Color(0, 0, 0));
        btnTP.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnTP.setForeground(new java.awt.Color(255, 255, 255));
        btnTP.setText("COMPRA DE TARJETA PERSONAL");
        btnTP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTPMouseClicked(evt);
            }
        });
        btnTP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTPActionPerformed(evt);
            }
        });

        btnPlataformaMapa.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnPlataformaMapa.setText("MAPA RUTAS");
        btnPlataformaMapa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPlataformaMapaMouseClicked(evt);
            }
        });

        jLabel60.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/f7.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel61, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addComponent(jLabel60, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnBoleto, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bntRecarga, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnTP, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btnPlataformaMapa, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel61, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(btnPlataformaMapa)
                        .addGap(26, 26, 26)
                        .addComponent(jLabel60, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(62, 62, 62)
                .addComponent(btnBoleto, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62)
                .addComponent(bntRecarga, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addComponent(btnTP, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(85, Short.MAX_VALUE))
        );

        pnlInicio.add(jPanel1);
        jPanel1.setBounds(350, 50, 460, 730);

        jLabel62.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/f3.jpg"))); // NOI18N
        pnlInicio.add(jLabel62);
        jLabel62.setBounds(0, 10, 1200, 800);

        pnlCards.add(pnlInicio, "crdInicio");

        pnlSacaBoleto.setLayout(null);

        jLabel10.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 255, 204));
        jLabel10.setText("[(( SACA TU BOLETO AQUI ))]");
        pnlSacaBoleto.add(jLabel10);
        jLabel10.setBounds(380, 60, 340, 52);

        txtSacaCodigo.setBackground(new java.awt.Color(51, 51, 51));
        txtSacaCodigo.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        txtSacaCodigo.setForeground(new java.awt.Color(255, 255, 255));
        txtSacaCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSacaCodigoActionPerformed(evt);
            }
        });
        pnlSacaBoleto.add(txtSacaCodigo);
        txtSacaCodigo.setBounds(330, 470, 470, 48);

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(204, 204, 204));
        jLabel14.setText("Ingrese SU C.I.:");
        pnlSacaBoleto.add(jLabel14);
        jLabel14.setBounds(430, 160, 288, 44);

        btnSacaAceptarBole.setBackground(new java.awt.Color(51, 51, 51));
        btnSacaAceptarBole.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        btnSacaAceptarBole.setForeground(new java.awt.Color(255, 255, 255));
        btnSacaAceptarBole.setText("ACEPTAR");
        btnSacaAceptarBole.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSacaAceptarBoleMouseClicked(evt);
            }
        });
        btnSacaAceptarBole.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSacaAceptarBoleActionPerformed(evt);
            }
        });
        pnlSacaBoleto.add(btnSacaAceptarBole);
        btnSacaAceptarBole.setBounds(240, 630, 201, 53);

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(204, 204, 204));
        jLabel15.setText("Ingrese SU CONTRASEÑA:");
        pnlSacaBoleto.add(jLabel15);
        jLabel15.setBounds(330, 370, 476, 44);

        txtSacaCI.setBackground(new java.awt.Color(51, 51, 51));
        txtSacaCI.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        txtSacaCI.setForeground(new java.awt.Color(255, 255, 255));
        txtSacaCI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSacaCIActionPerformed(evt);
            }
        });
        txtSacaCI.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSacaCIKeyTyped(evt);
            }
        });
        pnlSacaBoleto.add(txtSacaCI);
        txtSacaCI.setBounds(330, 260, 470, 48);

        btnSacaAceptar2.setBackground(new java.awt.Color(51, 51, 51));
        btnSacaAceptar2.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        btnSacaAceptar2.setForeground(new java.awt.Color(255, 255, 255));
        btnSacaAceptar2.setText("SALIR");
        btnSacaAceptar2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSacaAceptar2MouseClicked(evt);
            }
        });
        btnSacaAceptar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSacaAceptar2ActionPerformed(evt);
            }
        });
        pnlSacaBoleto.add(btnSacaAceptar2);
        btnSacaAceptar2.setBounds(690, 630, 201, 53);

        jLabel63.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/f2.jpg"))); // NOI18N
        pnlSacaBoleto.add(jLabel63);
        jLabel63.setBounds(0, 0, 1210, 830);

        pnlCards.add(pnlSacaBoleto, "crdSacaBol");

        pnlSacaTarjeta.setLayout(null);

        jLabel26.setFont(new java.awt.Font("Sylfaen", 1, 24)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(0, 255, 204));
        jLabel26.setText("[(( SACA TU TARJETA AQUI ))]");
        pnlSacaTarjeta.add(jLabel26);
        jLabel26.setBounds(386, 31, 359, 52);

        txtSacaCodigoT.setBackground(new java.awt.Color(51, 51, 51));
        txtSacaCodigoT.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        txtSacaCodigoT.setForeground(new java.awt.Color(255, 255, 255));
        txtSacaCodigoT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSacaCodigoTActionPerformed(evt);
            }
        });
        txtSacaCodigoT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSacaCodigoTKeyTyped(evt);
            }
        });
        pnlSacaTarjeta.add(txtSacaCodigoT);
        txtSacaCodigoT.setBounds(330, 460, 520, 48);

        jLabel29.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(204, 204, 204));
        jLabel29.setText("Ingrese SU C.I.:");
        pnlSacaTarjeta.add(jLabel29);
        jLabel29.setBounds(438, 152, 288, 44);

        btnSacaTarjetaPropia.setBackground(new java.awt.Color(51, 51, 51));
        btnSacaTarjetaPropia.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        btnSacaTarjetaPropia.setForeground(new java.awt.Color(255, 255, 255));
        btnSacaTarjetaPropia.setText("ACEPTAR");
        btnSacaTarjetaPropia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSacaTarjetaPropiaMouseClicked(evt);
            }
        });
        btnSacaTarjetaPropia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSacaTarjetaPropiaActionPerformed(evt);
            }
        });
        pnlSacaTarjeta.add(btnSacaTarjetaPropia);
        btnSacaTarjetaPropia.setBounds(250, 630, 201, 53);

        jLabel30.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(204, 204, 204));
        jLabel30.setText("Ingrese SU CONTRASEÑA:");
        pnlSacaTarjeta.add(jLabel30);
        jLabel30.setBounds(367, 359, 476, 44);

        txtSacaCIT.setBackground(new java.awt.Color(51, 51, 51));
        txtSacaCIT.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        txtSacaCIT.setForeground(new java.awt.Color(255, 255, 255));
        txtSacaCIT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSacaCITActionPerformed(evt);
            }
        });
        txtSacaCIT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSacaCITKeyTyped(evt);
            }
        });
        pnlSacaTarjeta.add(txtSacaCIT);
        txtSacaCIT.setBounds(335, 241, 520, 48);

        btnSacaTSalir.setBackground(new java.awt.Color(51, 51, 51));
        btnSacaTSalir.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        btnSacaTSalir.setForeground(new java.awt.Color(255, 255, 255));
        btnSacaTSalir.setText("SALIR");
        btnSacaTSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSacaTSalirMouseClicked(evt);
            }
        });
        btnSacaTSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSacaTSalirActionPerformed(evt);
            }
        });
        pnlSacaTarjeta.add(btnSacaTSalir);
        btnSacaTSalir.setBounds(740, 630, 195, 53);

        jLabel64.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/f2.jpg"))); // NOI18N
        pnlSacaTarjeta.add(jLabel64);
        jLabel64.setBounds(0, 0, 1200, 820);

        pnlCards.add(pnlSacaTarjeta, "crdSacarTarjeta");

        pnlCompraBoleto.setLayout(null);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setText("COMPRA DE BOLETO INTELIGENTE");
        pnlCompraBoleto.add(jLabel3);
        jLabel3.setBounds(80, 70, 870, 58);

        jLabel4.setBackground(new java.awt.Color(0, 0, 0));
        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Ingrese SU C.I.:");
        pnlCompraBoleto.add(jLabel4);
        jLabel4.setBounds(20, 300, 300, 44);

        jLabel7.setBackground(new java.awt.Color(0, 0, 0));
        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Ingrese SU CONTRASEÑA:");
        pnlCompraBoleto.add(jLabel7);
        jLabel7.setBounds(20, 380, 480, 44);

        txtCiBoleto.setBackground(new java.awt.Color(102, 102, 102));
        txtCiBoleto.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        txtCiBoleto.setForeground(new java.awt.Color(255, 255, 255));
        txtCiBoleto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCiBoletoActionPerformed(evt);
            }
        });
        txtCiBoleto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCiBoletoKeyTyped(evt);
            }
        });
        pnlCompraBoleto.add(txtCiBoleto);
        txtCiBoleto.setBounds(510, 290, 600, 46);

        txtContraseñaBoleto.setBackground(new java.awt.Color(102, 102, 102));
        txtContraseñaBoleto.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        txtContraseñaBoleto.setForeground(new java.awt.Color(255, 255, 255));
        txtContraseñaBoleto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtContraseñaBoletoKeyTyped(evt);
            }
        });
        pnlCompraBoleto.add(txtContraseñaBoleto);
        txtContraseñaBoleto.setBounds(510, 370, 600, 45);

        txtCostoBoleto.setEditable(false);
        txtCostoBoleto.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        txtCostoBoleto.setText("3");
        txtCostoBoleto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCostoBoletoActionPerformed(evt);
            }
        });
        pnlCompraBoleto.add(txtCostoBoleto);
        txtCostoBoleto.setBounds(870, 660, 123, 45);

        btnAceBol.setBackground(new java.awt.Color(0, 0, 0));
        btnAceBol.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        btnAceBol.setForeground(new java.awt.Color(153, 153, 153));
        btnAceBol.setText("ACEPTAR");
        btnAceBol.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAceBolMouseClicked(evt);
            }
        });
        btnAceBol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceBolActionPerformed(evt);
            }
        });
        pnlCompraBoleto.add(btnAceBol);
        btnAceBol.setBounds(180, 740, 181, 53);

        btnSalirBol.setBackground(new java.awt.Color(0, 0, 0));
        btnSalirBol.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        btnSalirBol.setForeground(new java.awt.Color(153, 153, 153));
        btnSalirBol.setText("SALIR");
        btnSalirBol.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSalirBolMouseClicked(evt);
            }
        });
        pnlCompraBoleto.add(btnSalirBol);
        btnSalirBol.setBounds(690, 740, 181, 53);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setText("¿Cuantas PARADAS HARAS?:");
        pnlCompraBoleto.add(jLabel5);
        jLabel5.setBounds(40, 590, 710, 60);

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(102, 102, 102));
        jLabel16.setText("COSTO:");
        pnlCompraBoleto.add(jLabel16);
        jLabel16.setBounds(810, 590, 190, 60);

        cbxParadas.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        cbxParadas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6" }));
        cbxParadas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxParadasActionPerformed(evt);
            }
        });
        pnlCompraBoleto.add(cbxParadas);
        cbxParadas.setBounds(570, 670, 90, 35);

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel17.setText("Bs");
        pnlCompraBoleto.add(jLabel17);
        jLabel17.setBounds(1020, 670, 28, 29);
        pnlCompraBoleto.add(jLabel66);
        jLabel66.setBounds(82, 560, 41, 25);

        jLabel67.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/f6.png"))); // NOI18N
        pnlCompraBoleto.add(jLabel67);
        jLabel67.setBounds(0, 0, 1190, 840);

        pnlCards.add(pnlCompraBoleto, "crdBolInt");

        pnlRecargaTarjeta.setBackground(new java.awt.Color(255, 153, 51));
        pnlRecargaTarjeta.setLayout(null);

        txtContraseñaRTA.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        txtContraseñaRTA.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtContraseñaRTAKeyTyped(evt);
            }
        });
        pnlRecargaTarjeta.add(txtContraseñaRTA);
        txtContraseñaRTA.setBounds(384, 340, 751, 45);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 255, 204));
        jLabel8.setText("Ingrese SU CONTRASEÑA:");
        pnlRecargaTarjeta.add(jLabel8);
        jLabel8.setBounds(50, 360, 314, 29);

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(51, 255, 204));
        jLabel11.setText("Ingrese SU C.I.:");
        pnlRecargaTarjeta.add(jLabel11);
        jLabel11.setBounds(50, 260, 192, 29);

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("RECARGA DE TARJETA");
        pnlRecargaTarjeta.add(jLabel12);
        jLabel12.setBounds(320, 150, 541, 58);

        txtCiRTA.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        txtCiRTA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCiRTAActionPerformed(evt);
            }
        });
        txtCiRTA.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCiRTAKeyTyped(evt);
            }
        });
        pnlRecargaTarjeta.add(txtCiRTA);
        txtCiRTA.setBounds(384, 248, 751, 44);

        btnAceptarRTA.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        btnAceptarRTA.setText("ACEPTAR");
        btnAceptarRTA.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAceptarRTAMouseClicked(evt);
            }
        });
        btnAceptarRTA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarRTAActionPerformed(evt);
            }
        });
        pnlRecargaTarjeta.add(btnAceptarRTA);
        btnAceptarRTA.setBounds(260, 590, 181, 53);

        btnSalirRecar.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        btnSalirRecar.setText("SALIR");
        btnSalirRecar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSalirRecarMouseClicked(evt);
            }
        });
        btnSalirRecar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirRecarActionPerformed(evt);
            }
        });
        pnlRecargaTarjeta.add(btnSalirRecar);
        btnSalirRecar.setBounds(780, 590, 181, 53);

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(51, 255, 204));
        jLabel13.setText("Ingrese EL MONTO:");
        pnlRecargaTarjeta.add(jLabel13);
        jLabel13.setBounds(50, 450, 235, 29);

        txtMontoRTA.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        txtMontoRTA.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtMontoRTAKeyTyped(evt);
            }
        });
        pnlRecargaTarjeta.add(txtMontoRTA);
        txtMontoRTA.setBounds(384, 431, 751, 45);

        jLabel68.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/f3.jpg"))); // NOI18N
        pnlRecargaTarjeta.add(jLabel68);
        jLabel68.setBounds(11, 3, 1170, 830);

        pnlCards.add(pnlRecargaTarjeta, "crdRecar");

        pnlComprarTarjeta.setBackground(new java.awt.Color(153, 153, 153));
        pnlComprarTarjeta.setLayout(null);

        txtContraseñaPT.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        txtContraseñaPT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtContraseñaPTActionPerformed(evt);
            }
        });
        txtContraseñaPT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtContraseñaPTKeyTyped(evt);
            }
        });
        pnlComprarTarjeta.add(txtContraseñaPT);
        txtContraseñaPT.setBounds(560, 370, 560, 45);

        jLabel18.setBackground(new java.awt.Color(255, 255, 255));
        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(204, 204, 204));
        jLabel18.setText("Ingrese SU CONTRASEÑA:");
        pnlComprarTarjeta.add(jLabel18);
        jLabel18.setBounds(70, 370, 476, 44);

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Ingrese SU C.I.:");
        pnlComprarTarjeta.add(jLabel21);
        jLabel21.setBounds(240, 300, 288, 44);

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("ADQUIERA SU PROPIA TARJETA");
        pnlComprarTarjeta.add(jLabel22);
        jLabel22.setBounds(280, 120, 774, 58);

        txtCIPT.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        txtCIPT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCIPTActionPerformed(evt);
            }
        });
        txtCIPT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCIPTKeyTyped(evt);
            }
        });
        pnlComprarTarjeta.add(txtCIPT);
        txtCIPT.setBounds(560, 300, 560, 44);

        btnPT.setBackground(new java.awt.Color(153, 153, 153));
        btnPT.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        btnPT.setForeground(new java.awt.Color(255, 255, 255));
        btnPT.setText("ACEPTAR");
        btnPT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPTMouseClicked(evt);
            }
        });
        btnPT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPTActionPerformed(evt);
            }
        });
        pnlComprarTarjeta.add(btnPT);
        btnPT.setBounds(350, 690, 181, 53);

        btnSalirTar.setBackground(new java.awt.Color(153, 153, 153));
        btnSalirTar.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        btnSalirTar.setForeground(new java.awt.Color(255, 255, 255));
        btnSalirTar.setText("SALIR");
        btnSalirTar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSalirTarMouseClicked(evt);
            }
        });
        btnSalirTar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirTarActionPerformed(evt);
            }
        });
        pnlComprarTarjeta.add(btnSalirTar);
        btnSalirTar.setBounds(730, 690, 181, 53);

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(204, 204, 204));
        jLabel23.setText("El Costo de LA TARJETA ES:");
        pnlComprarTarjeta.add(jLabel23);
        jLabel23.setBounds(70, 490, 498, 44);

        txtMontoPT.setEditable(false);
        txtMontoPT.setBackground(new java.awt.Color(0, 0, 0));
        txtMontoPT.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        txtMontoPT.setForeground(new java.awt.Color(255, 255, 255));
        txtMontoPT.setText("20");
        txtMontoPT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtMontoPTKeyTyped(evt);
            }
        });
        pnlComprarTarjeta.add(txtMontoPT);
        txtMontoPT.setBounds(610, 480, 68, 45);

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("Bs");
        pnlComprarTarjeta.add(jLabel24);
        jLabel24.setBounds(690, 500, 28, 29);

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(204, 204, 204));
        jLabel25.setText("CON UN SALDO DE:");
        pnlComprarTarjeta.add(jLabel25);
        jLabel25.setBounds(660, 570, 234, 29);

        txtSaldoPT.setEditable(false);
        txtSaldoPT.setBackground(new java.awt.Color(0, 0, 0));
        txtSaldoPT.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        txtSaldoPT.setForeground(new java.awt.Color(255, 255, 255));
        txtSaldoPT.setText("10");
        txtSaldoPT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSaldoPTKeyTyped(evt);
            }
        });
        pnlComprarTarjeta.add(txtSaldoPT);
        txtSaldoPT.setBounds(930, 560, 68, 45);

        jLabel34.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(255, 255, 255));
        jLabel34.setText("Bs");
        pnlComprarTarjeta.add(jLabel34);
        jLabel34.setBounds(1010, 580, 28, 29);

        jLabel69.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/189.jpg"))); // NOI18N
        pnlComprarTarjeta.add(jLabel69);
        jLabel69.setBounds(0, 0, 1190, 840);

        pnlCards.add(pnlComprarTarjeta, "crdAT");

        pnlMapa.setBackground(new java.awt.Color(0, 0, 0));
        pnlMapa.setLayout(null);

        btnSalirMapa.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        btnSalirMapa.setText("VOLVER");
        btnSalirMapa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSalirMapaMouseClicked(evt);
            }
        });
        btnSalirMapa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirMapaActionPerformed(evt);
            }
        });
        pnlMapa.add(btnSalirMapa);
        btnSalirMapa.setBounds(920, 50, 200, 40);

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/teleferico2.jpg"))); // NOI18N
        pnlMapa.add(jLabel19);
        jLabel19.setBounds(110, 70, 1000, 730);

        pnlCards.add(pnlMapa, "crdMapa");

        pnlRegistroDelDia.setBackground(new java.awt.Color(102, 102, 102));
        pnlRegistroDelDia.setLayout(null);

        pnlEmpleadosTitle1.setBackground(new java.awt.Color(0, 0, 0));
        pnlEmpleadosTitle1.setForeground(new java.awt.Color(255, 255, 255));

        jLabel31.setFont(new java.awt.Font("DejaVu Sans", 1, 48)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel31.setText("REGISTRO DEL DIA");

        javax.swing.GroupLayout pnlEmpleadosTitle1Layout = new javax.swing.GroupLayout(pnlEmpleadosTitle1);
        pnlEmpleadosTitle1.setLayout(pnlEmpleadosTitle1Layout);
        pnlEmpleadosTitle1Layout.setHorizontalGroup(
            pnlEmpleadosTitle1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEmpleadosTitle1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 468, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );
        pnlEmpleadosTitle1Layout.setVerticalGroup(
            pnlEmpleadosTitle1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlEmpleadosTitle1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnlRegistroDelDia.add(pnlEmpleadosTitle1);
        pnlEmpleadosTitle1.setBounds(314, 31, 526, 88);

        btnMostarRDD.setBackground(new java.awt.Color(0, 0, 0));
        btnMostarRDD.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnMostarRDD.setForeground(new java.awt.Color(153, 153, 153));
        btnMostarRDD.setText("<ACTUALIZAR>");
        btnMostarRDD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMostarRDDMouseClicked(evt);
            }
        });
        btnMostarRDD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostarRDDActionPerformed(evt);
            }
        });
        pnlRegistroDelDia.add(btnMostarRDD);
        btnMostarRDD.setBounds(66, 128, 177, 31);

        tblRDD.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        tblRDD.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CI:", "NOMBRE:", "SE REALIZO:", "FECHA:", "HORA:"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblRDD);

        pnlRegistroDelDia.add(jScrollPane2);
        jScrollPane2.setBounds(31, 177, 1129, 617);

        pnlCards.add(pnlRegistroDelDia, "crdMostrarRegistroDD");

        pnlMostrarUsuariosTarjeta.setBackground(new java.awt.Color(102, 102, 102));

        pnlEmpleadosTitle2.setBackground(new java.awt.Color(0, 0, 0));

        jLabel32.setFont(new java.awt.Font("DejaVu Sans", 1, 48)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 255, 255));
        jLabel32.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel32.setText("USUARIOS DE TARJETAS");

        javax.swing.GroupLayout pnlEmpleadosTitle2Layout = new javax.swing.GroupLayout(pnlEmpleadosTitle2);
        pnlEmpleadosTitle2.setLayout(pnlEmpleadosTitle2Layout);
        pnlEmpleadosTitle2Layout.setHorizontalGroup(
            pnlEmpleadosTitle2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 605, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        pnlEmpleadosTitle2Layout.setVerticalGroup(
            pnlEmpleadosTitle2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlEmpleadosTitle2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel32, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        btnMostrarUDT.setBackground(new java.awt.Color(0, 0, 0));
        btnMostrarUDT.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnMostrarUDT.setForeground(new java.awt.Color(153, 153, 153));
        btnMostrarUDT.setText("<ACTUALIZAR>");
        btnMostrarUDT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMostrarUDTMouseClicked(evt);
            }
        });
        btnMostrarUDT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrarUDTActionPerformed(evt);
            }
        });

        tblUDT.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        tblUDT.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CI:", "NOMBRE:", "MONTO"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tblUDT);

        javax.swing.GroupLayout pnlMostrarUsuariosTarjetaLayout = new javax.swing.GroupLayout(pnlMostrarUsuariosTarjeta);
        pnlMostrarUsuariosTarjeta.setLayout(pnlMostrarUsuariosTarjetaLayout);
        pnlMostrarUsuariosTarjetaLayout.setHorizontalGroup(
            pnlMostrarUsuariosTarjetaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMostrarUsuariosTarjetaLayout.createSequentialGroup()
                .addGroup(pnlMostrarUsuariosTarjetaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlMostrarUsuariosTarjetaLayout.createSequentialGroup()
                        .addGap(297, 297, 297)
                        .addComponent(pnlEmpleadosTitle2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlMostrarUsuariosTarjetaLayout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addGroup(pnlMostrarUsuariosTarjetaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnMostrarUDT)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 1096, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(49, Short.MAX_VALUE))
        );
        pnlMostrarUsuariosTarjetaLayout.setVerticalGroup(
            pnlMostrarUsuariosTarjetaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMostrarUsuariosTarjetaLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(pnlEmpleadosTitle2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(btnMostrarUDT)
                .addGap(26, 26, 26)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 565, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(64, Short.MAX_VALUE))
        );

        pnlCards.add(pnlMostrarUsuariosTarjeta, "crdMUDT");

        pnlMostrarUsuariosTigoMoney.setBackground(new java.awt.Color(153, 153, 153));

        pnlEmpleadosTitle5.setBackground(new java.awt.Color(0, 0, 0));

        jLabel36.setFont(new java.awt.Font("DejaVu Sans", 1, 48)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(255, 255, 255));
        jLabel36.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel36.setText("USUARIOS DE TIGOMONEY");

        javax.swing.GroupLayout pnlEmpleadosTitle5Layout = new javax.swing.GroupLayout(pnlEmpleadosTitle5);
        pnlEmpleadosTitle5.setLayout(pnlEmpleadosTitle5Layout);
        pnlEmpleadosTitle5Layout.setHorizontalGroup(
            pnlEmpleadosTitle5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlEmpleadosTitle5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 640, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnlEmpleadosTitle5Layout.setVerticalGroup(
            pnlEmpleadosTitle5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlEmpleadosTitle5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel36, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        btnMostrarUDTigo.setBackground(new java.awt.Color(0, 0, 0));
        btnMostrarUDTigo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnMostrarUDTigo.setForeground(new java.awt.Color(153, 153, 153));
        btnMostrarUDTigo.setText("<ACTUALIZAR>");
        btnMostrarUDTigo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMostrarUDTigoMouseClicked(evt);
            }
        });
        btnMostrarUDTigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrarUDTigoActionPerformed(evt);
            }
        });

        tblUDTigo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        tblUDTigo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CI:", "NOMBRE:", "Nro CELULAR", "SALDO"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane6.setViewportView(tblUDTigo);

        javax.swing.GroupLayout pnlMostrarUsuariosTigoMoneyLayout = new javax.swing.GroupLayout(pnlMostrarUsuariosTigoMoney);
        pnlMostrarUsuariosTigoMoney.setLayout(pnlMostrarUsuariosTigoMoneyLayout);
        pnlMostrarUsuariosTigoMoneyLayout.setHorizontalGroup(
            pnlMostrarUsuariosTigoMoneyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlMostrarUsuariosTigoMoneyLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(pnlEmpleadosTitle5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(266, 266, 266))
            .addGroup(pnlMostrarUsuariosTigoMoneyLayout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(pnlMostrarUsuariosTigoMoneyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnMostrarUDTigo)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 1054, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(91, Short.MAX_VALUE))
        );
        pnlMostrarUsuariosTigoMoneyLayout.setVerticalGroup(
            pnlMostrarUsuariosTigoMoneyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMostrarUsuariosTigoMoneyLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(pnlEmpleadosTitle5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addComponent(btnMostrarUDTigo)
                .addGap(26, 26, 26)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 572, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(57, Short.MAX_VALUE))
        );

        pnlCards.add(pnlMostrarUsuariosTigoMoney, "crdUsuarioTM");

        pnlMostrarSacarBoletoTarjeta.setBackground(new java.awt.Color(153, 153, 153));

        pnlEmpleadosTitle6.setBackground(new java.awt.Color(0, 0, 0));

        jLabel37.setFont(new java.awt.Font("DejaVu Sans", 1, 48)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(255, 255, 255));
        jLabel37.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel37.setText("SACAR BOLETO, TARJETA");

        javax.swing.GroupLayout pnlEmpleadosTitle6Layout = new javax.swing.GroupLayout(pnlEmpleadosTitle6);
        pnlEmpleadosTitle6.setLayout(pnlEmpleadosTitle6Layout);
        pnlEmpleadosTitle6Layout.setHorizontalGroup(
            pnlEmpleadosTitle6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlEmpleadosTitle6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 640, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnlEmpleadosTitle6Layout.setVerticalGroup(
            pnlEmpleadosTitle6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlEmpleadosTitle6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel37, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        btnMostrarSBT.setBackground(new java.awt.Color(0, 0, 0));
        btnMostrarSBT.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnMostrarSBT.setForeground(new java.awt.Color(153, 153, 153));
        btnMostrarSBT.setText("<ACTUALIZAR>");
        btnMostrarSBT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMostrarSBTMouseClicked(evt);
            }
        });
        btnMostrarSBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrarSBTActionPerformed(evt);
            }
        });

        tblSBT.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        tblSBT.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CI:", "NOMBRE:", "TIPO COMPRA:", "FECHA:", "HORA:"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane7.setViewportView(tblSBT);

        javax.swing.GroupLayout pnlMostrarSacarBoletoTarjetaLayout = new javax.swing.GroupLayout(pnlMostrarSacarBoletoTarjeta);
        pnlMostrarSacarBoletoTarjeta.setLayout(pnlMostrarSacarBoletoTarjetaLayout);
        pnlMostrarSacarBoletoTarjetaLayout.setHorizontalGroup(
            pnlMostrarSacarBoletoTarjetaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMostrarSacarBoletoTarjetaLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(pnlMostrarSacarBoletoTarjetaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnMostrarSBT)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 1112, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(65, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlMostrarSacarBoletoTarjetaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pnlEmpleadosTitle6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(261, 261, 261))
        );
        pnlMostrarSacarBoletoTarjetaLayout.setVerticalGroup(
            pnlMostrarSacarBoletoTarjetaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMostrarSacarBoletoTarjetaLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(pnlEmpleadosTitle6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnMostrarSBT)
                .addGap(27, 27, 27)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 588, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(41, Short.MAX_VALUE))
        );

        pnlCards.add(pnlMostrarSacarBoletoTarjeta, "crdSBT");

        pnlCrearTigoMoney.setBackground(new java.awt.Color(0, 0, 0));

        txtCTMN.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        txtCTMN.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCTMNKeyTyped(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Ingrese SU NOMBRE:");

        jLabel20.setBackground(new java.awt.Color(255, 255, 255));
        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Ingrese SU C.I.:");

        jLabel33.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(255, 0, 0));
        jLabel33.setText("CREAR CUENTA TIGO MONEY");

        txtCTMCI.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        txtCTMCI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCTMCIActionPerformed(evt);
            }
        });
        txtCTMCI.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCTMCIKeyTyped(evt);
            }
        });

        btnAceptarCTM.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        btnAceptarCTM.setText("ACEPTAR");
        btnAceptarCTM.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAceptarCTMMouseClicked(evt);
            }
        });
        btnAceptarCTM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarCTMActionPerformed(evt);
            }
        });

        jLabel35.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(255, 255, 255));
        jLabel35.setText("Ingrese EL Monto Incial:");

        txtCTMM.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        txtCTMM.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCTMMKeyTyped(evt);
            }
        });

        jLabel38.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(255, 255, 255));
        jLabel38.setText("Ingrese EL Nro CELULAR:");

        txtCTMCEL.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        txtCTMCEL.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCTMCELKeyTyped(evt);
            }
        });

        txtCTMCSE.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        txtCTMCSE.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCTMCSEKeyTyped(evt);
            }
        });

        jLabel39.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(255, 255, 255));
        jLabel39.setText("Ingrese CodigoSeguridad:");

        javax.swing.GroupLayout pnlCrearTigoMoneyLayout = new javax.swing.GroupLayout(pnlCrearTigoMoney);
        pnlCrearTigoMoney.setLayout(pnlCrearTigoMoneyLayout);
        pnlCrearTigoMoneyLayout.setHorizontalGroup(
            pnlCrearTigoMoneyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCrearTigoMoneyLayout.createSequentialGroup()
                .addGroup(pnlCrearTigoMoneyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlCrearTigoMoneyLayout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addGroup(pnlCrearTigoMoneyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(pnlCrearTigoMoneyLayout.createSequentialGroup()
                                .addComponent(jLabel20)
                                .addGap(135, 135, 135)
                                .addComponent(txtCTMCI, javax.swing.GroupLayout.PREFERRED_SIZE, 751, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlCrearTigoMoneyLayout.createSequentialGroup()
                                .addGroup(pnlCrearTigoMoneyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel35)
                                    .addComponent(jLabel38)
                                    .addComponent(jLabel39))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(pnlCrearTigoMoneyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtCTMN, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 751, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCTMM, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 751, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCTMCEL, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 751, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCTMCSE, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 751, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(pnlCrearTigoMoneyLayout.createSequentialGroup()
                        .addGap(237, 237, 237)
                        .addComponent(jLabel33))
                    .addGroup(pnlCrearTigoMoneyLayout.createSequentialGroup()
                        .addGap(485, 485, 485)
                        .addComponent(btnAceptarCTM)))
                .addContainerGap(63, Short.MAX_VALUE))
        );
        pnlCrearTigoMoneyLayout.setVerticalGroup(
            pnlCrearTigoMoneyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCrearTigoMoneyLayout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(jLabel33)
                .addGap(59, 59, 59)
                .addGroup(pnlCrearTigoMoneyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlCrearTigoMoneyLayout.createSequentialGroup()
                        .addGroup(pnlCrearTigoMoneyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtCTMCI, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel20))
                        .addGap(30, 30, 30)
                        .addGroup(pnlCrearTigoMoneyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel9)
                            .addComponent(txtCTMN, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)
                        .addComponent(txtCTMM, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel35))
                .addGap(30, 30, 30)
                .addGroup(pnlCrearTigoMoneyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCrearTigoMoneyLayout.createSequentialGroup()
                        .addGroup(pnlCrearTigoMoneyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel38)
                            .addComponent(txtCTMCEL, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addComponent(txtCTMCSE, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel39, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(99, 99, 99)
                .addComponent(btnAceptarCTM)
                .addContainerGap(149, Short.MAX_VALUE))
        );

        pnlCards.add(pnlCrearTigoMoney, "crdCTMoney");

        pnlRecargaCuentaTigoMoney.setLayout(null);

        txtRTMContraseña.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        txtRTMContraseña.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtRTMContraseñaKeyTyped(evt);
            }
        });
        pnlRecargaCuentaTigoMoney.add(txtRTMContraseña);
        txtRTMContraseña.setBounds(489, 340, 611, 45);

        jLabel40.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel40.setText("Ingrese SU CONTRASEÑA:");
        pnlRecargaCuentaTigoMoney.add(jLabel40);
        jLabel40.setBounds(137, 356, 314, 29);

        jLabel41.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel41.setText("Ingrese SU Nro Celular:");
        pnlRecargaCuentaTigoMoney.add(jLabel41);
        jLabel41.setBounds(137, 255, 282, 29);

        jLabel42.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel42.setText("RECARGA DE TIGOMONEY");
        pnlRecargaCuentaTigoMoney.add(jLabel42);
        jLabel42.setBounds(281, 65, 632, 58);

        txtRTMCelular.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        txtRTMCelular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRTMCelularActionPerformed(evt);
            }
        });
        txtRTMCelular.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtRTMCelularKeyTyped(evt);
            }
        });
        pnlRecargaCuentaTigoMoney.add(txtRTMCelular);
        txtRTMCelular.setBounds(489, 248, 611, 44);

        btnAceptarRTMoney.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        btnAceptarRTMoney.setText("ACEPTAR");
        btnAceptarRTMoney.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAceptarRTMoneyMouseClicked(evt);
            }
        });
        btnAceptarRTMoney.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarRTMoneyActionPerformed(evt);
            }
        });
        pnlRecargaCuentaTigoMoney.add(btnAceptarRTMoney);
        btnAceptarRTMoney.setBounds(438, 565, 257, 67);

        jLabel43.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel43.setText("Monto A RECARGAR:");
        pnlRecargaCuentaTigoMoney.add(jLabel43);
        jLabel43.setBounds(137, 447, 247, 29);

        txtTMMonto.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        txtTMMonto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTMMontoKeyTyped(evt);
            }
        });
        pnlRecargaCuentaTigoMoney.add(txtTMMonto);
        txtTMMonto.setBounds(489, 431, 611, 45);
        pnlRecargaCuentaTigoMoney.add(jLabel65);
        jLabel65.setBounds(0, 0, 1200, 820);

        pnlCards.add(pnlRecargaCuentaTigoMoney, "crdReCTM");

        pnlFacturaBol.setBackground(new java.awt.Color(0, 0, 0));

        jPanel2.setBackground(new java.awt.Color(255, 204, 204));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setText("\"MI TELEFERICO\"");

        jLabel44.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel44.setText("EMPRESA ESTATAL DE TRANSPORTE POR CABLE");

        jLabel45.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel45.setText("Telefono: 2179300");

        jLabel46.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel46.setText("BOLETO INTELIGENTE");

        jLabel47.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel47.setText("--------------------------------------------------------");

        jLabel48.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel48.setText("NIT: 28001233");

        jLabel49.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel49.setText("Factura NRO: 3221709");

        jLabel50.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel50.setText("--------------------------------------------------------");

        jLabel51.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel51.setText("Fecha:");

        jLabel52.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel52.setText("Hora:");

        jLabel53.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel53.setText("Señor(ar):");

        jLabel54.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel54.setText("NIT\\CI:");

        jLabel55.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel55.setText("--------------------------------------------------------");

        jLabel56.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel56.setText("CODIGO DE CONTROL: B7-C5-75-C5");

        jLabel57.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel57.setText("--------------------------------------------------------");

        jLabel58.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel58.setText("TOTAL BS:");

        txtFacturaF.setEditable(false);
        txtFacturaF.setBackground(new java.awt.Color(255, 204, 204));
        txtFacturaF.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        txtFacturaH.setEditable(false);
        txtFacturaH.setBackground(new java.awt.Color(255, 204, 204));
        txtFacturaH.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        txtFacturaN.setEditable(false);
        txtFacturaN.setBackground(new java.awt.Color(255, 204, 204));
        txtFacturaN.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        txtFacturaCCC.setEditable(false);
        txtFacturaCCC.setBackground(new java.awt.Color(255, 204, 204));
        txtFacturaCCC.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        txtFacturaTotal.setEditable(false);
        txtFacturaTotal.setBackground(new java.awt.Color(255, 204, 204));
        txtFacturaTotal.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/f11.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(54, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel45, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(198, 198, 198))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 407, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(61, 61, 61)))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel55)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel54)
                                    .addGap(41, 41, 41)
                                    .addComponent(txtFacturaCCC))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel53)
                                    .addGap(22, 22, 22)
                                    .addComponent(txtFacturaN))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel52)
                                    .addGap(59, 59, 59)
                                    .addComponent(txtFacturaH))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel51)
                                    .addGap(51, 51, 51)
                                    .addComponent(txtFacturaF))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel48)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel49))
                                .addComponent(jLabel47, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel50)
                                .addComponent(jLabel57)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel58)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(txtFacturaTotal))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGap(46, 46, 46)
                                    .addComponent(jLabel56)))
                            .addContainerGap()))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel46)
                        .addGap(136, 136, 136))))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(128, 128, 128)
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel44)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel45)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel46)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel47)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel48)
                    .addComponent(jLabel49))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel50)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel51)
                    .addComponent(txtFacturaF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel52)
                    .addComponent(txtFacturaH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel53)
                    .addComponent(txtFacturaN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFacturaCCC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel54))
                .addGap(12, 12, 12)
                .addComponent(jLabel55)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel56)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel58)
                    .addComponent(txtFacturaTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addComponent(jLabel57)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        btnFacturaListo.setBackground(new java.awt.Color(0, 0, 0));
        btnFacturaListo.setFont(new java.awt.Font("Times New Roman", 0, 48)); // NOI18N
        btnFacturaListo.setForeground(new java.awt.Color(255, 255, 255));
        btnFacturaListo.setText("LISTO!");
        btnFacturaListo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnFacturaListoMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnlFacturaBolLayout = new javax.swing.GroupLayout(pnlFacturaBol);
        pnlFacturaBol.setLayout(pnlFacturaBolLayout);
        pnlFacturaBolLayout.setHorizontalGroup(
            pnlFacturaBolLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFacturaBolLayout.createSequentialGroup()
                .addGap(152, 152, 152)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(132, 132, 132)
                .addComponent(btnFacturaListo)
                .addContainerGap(211, Short.MAX_VALUE))
        );
        pnlFacturaBolLayout.setVerticalGroup(
            pnlFacturaBolLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFacturaBolLayout.createSequentialGroup()
                .addGroup(pnlFacturaBolLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlFacturaBolLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlFacturaBolLayout.createSequentialGroup()
                        .addGap(346, 346, 346)
                        .addComponent(btnFacturaListo)))
                .addContainerGap(41, Short.MAX_VALUE))
        );

        pnlCards.add(pnlFacturaBol, "crdFacturaMostrar");

        pnlTarjetaPropia.setBackground(new java.awt.Color(0, 0, 0));
        pnlTarjetaPropia.setLayout(null);

        btnTarjetaListo.setBackground(new java.awt.Color(255, 51, 51));
        btnTarjetaListo.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        btnTarjetaListo.setText("LISTO!");
        btnTarjetaListo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTarjetaListoMouseClicked(evt);
            }
        });
        pnlTarjetaPropia.add(btnTarjetaListo);
        btnTarjetaListo.setBounds(890, 390, 260, 60);

        jLabel59.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel59.setForeground(new java.awt.Color(255, 255, 255));
        jLabel59.setText("GRACIAS POR SU COMPRA!!");
        pnlTarjetaPropia.add(jLabel59);
        jLabel59.setBounds(240, 70, 710, 58);

        txtTarjetaNombreOK.setEditable(false);
        txtTarjetaNombreOK.setBackground(new java.awt.Color(102, 102, 102));
        txtTarjetaNombreOK.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        txtTarjetaNombreOK.setForeground(new java.awt.Color(255, 255, 255));
        pnlTarjetaPropia.add(txtTarjetaNombreOK);
        txtTarjetaNombreOK.setBounds(430, 290, 240, 30);

        txtTarjetaCIOK.setEditable(false);
        txtTarjetaCIOK.setBackground(new java.awt.Color(102, 102, 102));
        txtTarjetaCIOK.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        txtTarjetaCIOK.setForeground(new java.awt.Color(255, 255, 255));
        pnlTarjetaPropia.add(txtTarjetaCIOK);
        txtTarjetaCIOK.setBounds(430, 240, 240, 30);

        txtTarjetaFechaOK.setEditable(false);
        txtTarjetaFechaOK.setBackground(new java.awt.Color(102, 102, 102));
        txtTarjetaFechaOK.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        txtTarjetaFechaOK.setForeground(new java.awt.Color(255, 255, 255));
        pnlTarjetaPropia.add(txtTarjetaFechaOK);
        txtTarjetaFechaOK.setBounds(130, 640, 210, 30);

        jLabel75.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/f13.png"))); // NOI18N
        pnlTarjetaPropia.add(jLabel75);
        jLabel75.setBounds(60, 210, 782, 490);

        pnlCards.add(pnlTarjetaPropia, "crdTarjetaMostrar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlCards, javax.swing.GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE))
            .addComponent(pnlHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlCards, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSacaBTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSacaBTMouseClicked
        layout.show(pnlCards, "crdSBT");
    }//GEN-LAST:event_btnSacaBTMouseClicked

    private void btnCabinasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCabinasMouseClicked
        layout.show(pnlCards, "crdInicio");
    }//GEN-LAST:event_btnCabinasMouseClicked

    private void btnCabinasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCabinasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCabinasActionPerformed

    private void btnSacaBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSacaBTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSacaBTActionPerformed

    private void btnAceBolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceBolActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAceBolActionPerformed

    private void btnSacarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSacarMouseClicked
        layout.show(pnlCards, "crdSacarBT");
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSacarMouseClicked

    private void btnSacarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSacarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSacarActionPerformed

    private void btnSalirRecarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalirRecarMouseClicked
      layout.show(pnlCards, "crdInicio");  
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSalirRecarMouseClicked

    private void btnSalirRecarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirRecarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSalirRecarActionPerformed

    private void btnSalirBolMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalirBolMouseClicked
         layout.show(pnlCards, "crdInicio");  
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSalirBolMouseClicked

    private void txtSacaCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSacaCodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSacaCodigoActionPerformed

    private void btnSacaAceptarBoleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSacaAceptarBoleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSacaAceptarBoleActionPerformed

    private void txtCiRTAKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCiRTAKeyTyped
        char c= evt.getKeyChar();
        if (c>'9' || c<'0')
        { evt.consume();
        }
    }//GEN-LAST:event_txtCiRTAKeyTyped

    private void txtCiRTAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCiRTAActionPerformed

    }//GEN-LAST:event_txtCiRTAActionPerformed

    private void txtContraseñaRTAKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtContraseñaRTAKeyTyped
        char c= evt.getKeyChar();
        if (c>'9' || c<'0')
        { evt.consume();
        }
    }//GEN-LAST:event_txtContraseñaRTAKeyTyped

    private void txtSacaCIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSacaCIActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSacaCIActionPerformed

    private void txtSacaCIKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSacaCIKeyTyped
        char c= evt.getKeyChar();
        if (c>'9' || c<'0')
        { evt.consume();
        }
        
    }//GEN-LAST:event_txtSacaCIKeyTyped

    private void txtMontoRTAKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMontoRTAKeyTyped
        char c= evt.getKeyChar();
        if (c>'9' || c<'0')
        { evt.consume();
        }
    }//GEN-LAST:event_txtMontoRTAKeyTyped

    private void btnAceptarRTAMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAceptarRTAMouseClicked
        CSCircularTarjeta auxC = new CSCircularTarjeta();
        int n = colaCTM.nElem();
        String ci = txtCiRTA.getText();
        Integer contraseña = 0;
        Integer monto = 0;
        if (!txtContraseñaRTA.getText().equals("")) {
            contraseña = Integer.parseInt(txtContraseñaRTA.getText());
        }
        if (!txtMontoRTA.getText().equals("")) 
        {   monto = Integer.parseInt(txtMontoRTA.getText());  
        }
        boolean sw = false;
        while(n>0)
        { TigoMoney dato = null;
          dato = colaCTM.eliminar();
            if (dato.getCi().equals(ci)) 
            {if (dato.getCodigoSeguridad() == contraseña) 
                { if (dato.getMonto()>=monto) 
                    {   if (colaCT.cargarTarjeta(ci, monto)) 
                        {int mtt = dato.getMonto()- monto;
                         String nom = dato.getNombre();
                         int contra= dato.getCodigoSeguridad();
                         int nroC = dato.getNroCelular();
                         TigoMoney tm = new TigoMoney(ci,nom,mtt,contra,nroC);
                         dato = null;
                         dato = tm;
                         sw = true; 
                         hf = new HoraFecha();
                         registroDD = new RegistroDelDia(nom,ci,"Recarga Tarjeta",monto,hf.getFecha(),hf.getHora());
                         pilaRDD.adicionar(registroDD); 
                        }else {JOptionPane.showMessageDialog(null, "NO POSEES UNA TARJETA");}  
                    }else {JOptionPane.showMessageDialog(null, "SALDO INSUFICIENTE");}    
                }else {JOptionPane.showMessageDialog(null, "ERROR EN LA CONTRASEÑA");}   
            }
           colaCTM.adicionar(dato); n--;
        }

        if (sw) 
        { txtCiRTA.setText("");
          txtContraseñaRTA.setText("");
          txtMontoRTA.setText("");
        }else {JOptionPane.showMessageDialog(null, "ERROR EN CI");}      
    }//GEN-LAST:event_btnAceptarRTAMouseClicked

    private void txtCiBoletoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCiBoletoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCiBoletoActionPerformed

    private void txtCiBoletoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCiBoletoKeyTyped
       char c= evt.getKeyChar();
        if (c>'9' || c<'0')
        { evt.consume();
        }  
    }//GEN-LAST:event_txtCiBoletoKeyTyped

    private void txtCostoBoletoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCostoBoletoActionPerformed
        
    }//GEN-LAST:event_txtCostoBoletoActionPerformed

    private void txtContraseñaBoletoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtContraseñaBoletoKeyTyped
      char c= evt.getKeyChar();
        if (c>'9' || c<'0')
        { evt.consume();
        }
    }//GEN-LAST:event_txtContraseñaBoletoKeyTyped

    private void cbxParadasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxParadasActionPerformed
       Integer para = Integer.parseInt(cbxParadas.getSelectedItem().toString());
       String valor = convertirCosto(para);
       txtCostoBoleto.setText(valor); 
    }//GEN-LAST:event_cbxParadasActionPerformed

    private void btnAceptarRTAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarRTAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAceptarRTAActionPerformed

    private void btnAceBolMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAceBolMouseClicked
        PilaTigoMoney auxt = new PilaTigoMoney();
        String ci = txtCiBoleto.getText();
        Integer cont = 0;       Integer monto = 0;
        if (!txtContraseñaBoleto.getText().equals("")) {
            cont = Integer.parseInt(txtContraseñaBoleto.getText());
        }
        if (!txtCostoBoleto.getText().equals("")) {
            monto= Integer.parseInt(txtCostoBoleto.getText());
        }
        TigoMoney au = null; boolean sw = false;String nomB="";
        int n = colaCTM.nElem();
        while(n>0)
        { TigoMoney dato = null;
          dato = colaCTM.eliminar();
            if (dato.getCi().equals(ci)) 
            {if (dato.getCodigoSeguridad() == cont) 
                { if (dato.getMonto()>=monto) 
                    {     int mtt = dato.getMonto()-monto;
                          String nom = dato.getNombre();
                          int contra= dato.getCodigoSeguridad();
                          int nroC = dato.getNroCelular();
                          TigoMoney tm = new TigoMoney(ci,nom,mtt,contra,nroC);
                          dato = null;
                          dato = tm;
                          sw = true; 
                         hf = new HoraFecha();
                         SacarTarjetaBol k = new SacarTarjetaBol(nom,ci,"BOLETO",monto,hf.getFecha(),hf.getHora(),contra);
                         pilaSTB.adicionar(k);
                         registroDD = new RegistroDelDia(nom,ci,"Compra Boleto",monto,hf.getFecha(),hf.getHora());
                         pilaRDD.adicionar(registroDD); 

                    }else {JOptionPane.showMessageDialog(null, "SALDO INSUFICIENTE");}    
                }else {JOptionPane.showMessageDialog(null, "ERROR EN LA CONTRASEÑA");}   
            }
           colaCTM.adicionar(dato); n--;
        }
        if (sw) 
        { txtCiBoleto.setText("");
          txtContraseñaBoleto.setText("");
          txtCostoBoleto.setText("0");
        }else {JOptionPane.showMessageDialog(null, "ERROR EN CI");}  
    }//GEN-LAST:event_btnAceBolMouseClicked

    private void txtContraseñaPTKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtContraseñaPTKeyTyped
       char c= evt.getKeyChar();
        if (c>'9' || c<'0')
        { evt.consume();
        }
    }//GEN-LAST:event_txtContraseñaPTKeyTyped

    private void txtCIPTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCIPTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCIPTActionPerformed

    private void txtCIPTKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCIPTKeyTyped
        char c= evt.getKeyChar();
        if (c>'9' || c<'0')
        { evt.consume();
        }  
    }//GEN-LAST:event_txtCIPTKeyTyped

    private void btnPTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPTMouseClicked
        String ci = txtCIPT.getText();
        Integer cont = 0;
        Integer monto = 0;
        Integer saldo = 0;
        if (!txtContraseñaPT.getText().equals("")) {
            cont = Integer.parseInt(txtContraseñaPT.getText());
        }
        if (!txtMontoPT.getText().equals("")) {
            monto = Integer.parseInt(txtMontoPT.getText());
        }
        if (!txtSaldoPT.getText().equals("")) {
            saldo = Integer.parseInt(txtSaldoPT.getText());
        }
        boolean sw = false;
        int n = colaCTM.nElem();
        while(n>0)
        { TigoMoney dato = null;
          dato = colaCTM.eliminar();
            if (dato.getCi().equals(ci)) 
            {if (dato.getCodigoSeguridad() == cont) 
                { if (dato.getMonto()>=monto) 
                    {   if (!colaCT.cargarTarjeta(ci, monto)) 
                        { int mtt = dato.getMonto()-monto;
                          String nom = dato.getNombre();
                          int contra= dato.getCodigoSeguridad();
                          int nroC = dato.getNroCelular();
                          TigoMoney tm = new TigoMoney(ci,nom,mtt,contra,nroC);
                          dato = null;
                          dato = tm;
                          sw = true;
                         Tarjeta tr = new Tarjeta(ci,nom,saldo);
                         colaCT.adicionar(tr); 
                         hf = new HoraFecha();
                         SacarTarjetaBol k = new SacarTarjetaBol(nom,ci,"TARJETA",monto,hf.getFecha(),hf.getHora(),contra);
                         pilaSTB.adicionar(k);
                         registroDD = new RegistroDelDia(nom,ci,"Compra Tarjeta",monto,hf.getFecha(),hf.getHora());
                         pilaRDD.adicionar(registroDD); 
                        }else {JOptionPane.showMessageDialog(null, "YA POSEES UNA TARJETA");}
                    }else {JOptionPane.showMessageDialog(null, "SALDO INSUFICIENTE");}    
                }else {JOptionPane.showMessageDialog(null, "ERROR EN LA CONTRASEÑA");}   
            }
           colaCTM.adicionar(dato); n--;
        }
        if (sw) 
        { txtCIPT.setText("");
          txtContraseñaPT.setText("");
        }else {JOptionPane.showMessageDialog(null, "ERROR EN CI");}   
    }//GEN-LAST:event_btnPTMouseClicked

    private void btnPTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnPTActionPerformed

    private void btnSalirTarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalirTarMouseClicked
       layout.show(pnlCards, "crdInicio");   
    }//GEN-LAST:event_btnSalirTarMouseClicked

    private void btnSalirTarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirTarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSalirTarActionPerformed

    private void txtMontoPTKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMontoPTKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMontoPTKeyTyped

    private void btnSacarBoletoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSacarBoletoMouseClicked
         layout.show(pnlCards, "crdSacaBol");     
    }//GEN-LAST:event_btnSacarBoletoMouseClicked

    private void txtSacaCodigoTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSacaCodigoTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSacaCodigoTActionPerformed

    private void btnSacaTarjetaPropiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSacaTarjetaPropiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSacaTarjetaPropiaActionPerformed

    private void txtSacaCITActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSacaCITActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSacaCITActionPerformed

    private void txtSacaCITKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSacaCITKeyTyped
       char c= evt.getKeyChar();
        if (c>'9' || c<'0')
        { evt.consume();
        }    
    }//GEN-LAST:event_txtSacaCITKeyTyped

    private void btnSacaTSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSacaTSalirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSacaTSalirActionPerformed

    private void btnSacarTarjetaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSacarTarjetaMouseClicked
        layout.show(pnlCards, "crdSacarTarjeta");     
    }//GEN-LAST:event_btnSacarTarjetaMouseClicked

    private void btnSacaTSalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSacaTSalirMouseClicked
        layout.show(pnlCards, "crdSacarBT");   
    }//GEN-LAST:event_btnSacaTSalirMouseClicked

    private void btnSalirMapaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalirMapaMouseClicked
       layout.show(pnlCards, "crdInicio");   
    }//GEN-LAST:event_btnSalirMapaMouseClicked

    private void btnSalirMapaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirMapaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSalirMapaActionPerformed

    private void btnMostarRDDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMostarRDDMouseClicked
        llenarTablaRegistroDD(pilaRDD);    
    }//GEN-LAST:event_btnMostarRDDMouseClicked

    private void btnMostarRDDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostarRDDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnMostarRDDActionPerformed

    private void btnMostrarUDTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMostrarUDTMouseClicked
          llenarTablaTarjeta(colaCT);     
    }//GEN-LAST:event_btnMostrarUDTMouseClicked

    private void btnMostrarUDTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarUDTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnMostrarUDTActionPerformed

    private void btnSacaAceptar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSacaAceptar2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSacaAceptar2ActionPerformed

    private void btnSacaAceptar2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSacaAceptar2MouseClicked
        layout.show(pnlCards, "crdSacarBT");       
    }//GEN-LAST:event_btnSacaAceptar2MouseClicked

    private void txtSaldoPTKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSaldoPTKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSaldoPTKeyTyped

    private void btnM1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnM1MouseClicked
        layout.show(pnlCards, "crdMostrarRegistroDD");  
    }//GEN-LAST:event_btnM1MouseClicked

    private void btnM1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnM1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnM1ActionPerformed

    private void btnM3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnM3MouseClicked
         layout.show(pnlCards, "crdMUDT");  
    }//GEN-LAST:event_btnM3MouseClicked

    private void btnM3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnM3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnM3ActionPerformed

    private void btnM4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnM4MouseClicked
        layout.show(pnlCards, "crdUsuarioTM"); 
    }//GEN-LAST:event_btnM4MouseClicked

    private void btnM4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnM4ActionPerformed
       layout.show(pnlCards, "crdMostrarUTM"); 
    }//GEN-LAST:event_btnM4ActionPerformed

    private void btnMostrarUDTigoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMostrarUDTigoMouseClicked
        llenarTablaTigoMoney(colaCTM);    
    }//GEN-LAST:event_btnMostrarUDTigoMouseClicked

    private void btnMostrarUDTigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarUDTigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnMostrarUDTigoActionPerformed

    private void btnMostrarSBTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMostrarSBTMouseClicked
           llenarTablaSacaBolTar(pilaSTB);   
    }//GEN-LAST:event_btnMostrarSBTMouseClicked

    private void btnMostrarSBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarSBTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnMostrarSBTActionPerformed

    private void btnM5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnM5MouseClicked
        layout.show(pnlCards, "crdCTMoney");
    }//GEN-LAST:event_btnM5MouseClicked

    private void btnM5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnM5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnM5ActionPerformed

    private void txtCTMNKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCTMNKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCTMNKeyTyped

    private void txtCTMCIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCTMCIActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCTMCIActionPerformed

    private void txtCTMCIKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCTMCIKeyTyped
       char c= evt.getKeyChar();
        if (c>'9' || c<'0')
        { evt.consume();
        }
    }//GEN-LAST:event_txtCTMCIKeyTyped

    private void btnAceptarCTMMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAceptarCTMMouseClicked
       String ci = txtCTMCI.getText();
       String nombre = txtCTMN.getText();
       Integer saldo = 0;
       Integer nroCel = 0;
       Integer contraseña = 0;
        if (!txtCTMM.getText().equals("")) {
            saldo = Integer.parseInt(txtCTMM.getText());
        }
        if (!txtCTMCEL.getText().equals("")) {
            nroCel = Integer.parseInt(txtCTMCEL.getText());
        }
        if (!txtCTMCSE.getText().equals("")) {
            contraseña = Integer.parseInt(txtCTMCSE.getText());
        }
        if (!ci.equals("")&&nroCel!=0&&contraseña!=0) 
        {
            if (!colaCTM.estaRegistrado(ci, nroCel)) 
            {   tigo = new TigoMoney(ci,nombre,saldo,contraseña,nroCel);
                colaCTM.adicionar(tigo);
                txtCTMCI.setText("");
                txtCTMN.setText("");
                txtCTMM.setText("");
                txtCTMCEL.setText("");
                txtCTMCSE.setText("");
            }
            else{JOptionPane.showMessageDialog(null, "YA POSEE UNA CUENTA TIGO MONEY");}    
        } else{JOptionPane.showMessageDialog(null, "ERROR DE DATOS");}        
    }//GEN-LAST:event_btnAceptarCTMMouseClicked

    private void btnAceptarCTMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarCTMActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAceptarCTMActionPerformed

    private void txtCTMMKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCTMMKeyTyped
       char c= evt.getKeyChar();
        if (c>'9' || c<'0')
        { evt.consume();
        }
    }//GEN-LAST:event_txtCTMMKeyTyped

    private void txtCTMCELKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCTMCELKeyTyped
        char c= evt.getKeyChar();
        if (c>'9' || c<'0')
        { evt.consume();
        }
    }//GEN-LAST:event_txtCTMCELKeyTyped

    private void txtCTMCSEKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCTMCSEKeyTyped
        char c= evt.getKeyChar();
        if (c>'9' || c<'0')
        { evt.consume();
        }
    }//GEN-LAST:event_txtCTMCSEKeyTyped

    private void txtRTMContraseñaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRTMContraseñaKeyTyped
       char c= evt.getKeyChar();
        if (c>'9' || c<'0')
        { evt.consume();
        }
    }//GEN-LAST:event_txtRTMContraseñaKeyTyped

    private void txtRTMCelularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRTMCelularActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRTMCelularActionPerformed

    private void txtRTMCelularKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRTMCelularKeyTyped
       char c= evt.getKeyChar();
        if (c>'9' || c<'0')
        { evt.consume();
        }
    }//GEN-LAST:event_txtRTMCelularKeyTyped

    private void btnAceptarRTMoneyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAceptarRTMoneyMouseClicked
        Integer cel = 0;
        Integer cont = 0;
        Integer monto = 0;
         if (!txtRTMCelular.getText().equals("")) {
            cel = Integer.parseInt(txtRTMCelular.getText());
        }
        if (!txtRTMContraseña.getText().equals("")) {
            cont = Integer.parseInt(txtRTMContraseña.getText());
        }
        if (!txtTMMonto.getText().equals("")) {
            monto = Integer.parseInt(txtTMMonto.getText());
        }
        int n = colaCTM.nElem();  boolean sw = false;
        while(n>0)
        { TigoMoney dato = null;
          dato = colaCTM.eliminar();
            if (dato.getNroCelular()==cel) 
            {   if (dato.getCodigoSeguridad() == cont) 
                {         int mtt = dato.getMonto()+monto;
                          String nom = dato.getNombre();
                          String ci = dato.getCi();
                          int contra= dato.getCodigoSeguridad();
                          int nroC = dato.getNroCelular();
                          TigoMoney tm = new TigoMoney(ci,nom,mtt,contra,nroC);
                          dato = null;      dato = tm;      sw = true;
                }else {JOptionPane.showMessageDialog(null, "ERROR EN LA CONTRASEÑA");}   
            }
           colaCTM.adicionar(dato); n--;
        }if (sw) {  txtRTMCelular.setText("");      txtRTMContraseña.setText(""); 
                    txtTMMonto.setText(""); 
                 }else JOptionPane.showMessageDialog(null, "ERROR DE DATOS");
  
    }//GEN-LAST:event_btnAceptarRTMoneyMouseClicked

    private void btnAceptarRTMoneyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarRTMoneyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAceptarRTMoneyActionPerformed

    private void txtTMMontoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTMMontoKeyTyped
        char c= evt.getKeyChar();
        if (c>'9' || c<'0')
        { evt.consume();
        }
    }//GEN-LAST:event_txtTMMontoKeyTyped

    private void btnRTMMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRTMMouseClicked
        layout.show(pnlCards, "crdReCTM");
    }//GEN-LAST:event_btnRTMMouseClicked

    private void btnRTMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRTMActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRTMActionPerformed

    private void btnSacaAceptarBoleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSacaAceptarBoleMouseClicked
        String ci = txtSacaCI.getText();
        Integer cont = 0;
        if (!txtSacaCodigo.getText().equals("")) {
            cont = Integer.parseInt(txtSacaCodigo.getText());
        }
        boolean sw = false;
        PilaSacarTarjetaBol aux = new PilaSacarTarjetaBol();
        SacarTarjetaBol tar = null;
        SacarTarjetaBol dato = null;
        while(!pilaSTB.esVacia())
        { tar = null;
          tar = pilaSTB.eliminar();
            if (!tar.getCIR().equals(ci)&&tar.getTipoR().equals("BOLETO")) 
            { aux.adicionar(tar);}
            else{dato = tar; sw = true;}
        }
        if (sw) 
        {   llenarFactura(dato);
            layout.show(pnlCards, "crdFacturaMostrar");
        
        }
        else {JOptionPane.showMessageDialog(null, "ERROR EN LOS DATOS");} 
    
    }//GEN-LAST:event_btnSacaAceptarBoleMouseClicked

    private void btnFacturaListoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFacturaListoMouseClicked
       layout.show(pnlCards, "crdSacarBT");       
    }//GEN-LAST:event_btnFacturaListoMouseClicked

    private void btnTarjetaListoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTarjetaListoMouseClicked
        layout.show(pnlCards, "crdSacarBT");
    }//GEN-LAST:event_btnTarjetaListoMouseClicked

    private void btnPlataformaMapaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPlataformaMapaMouseClicked
        layout.show(pnlCards, "crdMapa");
    }//GEN-LAST:event_btnPlataformaMapaMouseClicked

    private void btnTPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnTPActionPerformed

    private void btnTPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTPMouseClicked
        layout.show(pnlCards, "crdAT");
    }//GEN-LAST:event_btnTPMouseClicked

    private void bntRecargaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntRecargaActionPerformed
        // TODO add your handling code here:
        layout.show(pnlCards, "crdRecar");
    }//GEN-LAST:event_bntRecargaActionPerformed

    private void bntRecargaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bntRecargaMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_bntRecargaMouseClicked

    private void btnBoletoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBoletoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBoletoActionPerformed

    private void btnBoletoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBoletoMouseClicked
        // TODO add your handling code here:
        layout.show(pnlCards, "crdBolInt");
    }//GEN-LAST:event_btnBoletoMouseClicked

    private void btnSacaTarjetaPropiaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSacaTarjetaPropiaMouseClicked
        String ci = txtSacaCIT.getText();
        Integer cont = 0;
        if (!txtSacaCodigoT.getText().equals("")) {
            cont = Integer.parseInt(txtSacaCodigoT.getText());
        }
        boolean sw = false;
        PilaSacarTarjetaBol aux = new PilaSacarTarjetaBol();
        SacarTarjetaBol tar = null;
        SacarTarjetaBol dato = null;
        while(!pilaSTB.esVacia())
        { tar = null;
          tar = pilaSTB.eliminar();
            if (!tar.getCIR().equals(ci)&&tar.getTipoR().equals("TARJETA")) 
            { aux.adicionar(tar);}
            else{dato = tar; sw = true;}
        }
        if (sw) 
        {   llenarTarjeta(dato);
            layout.show(pnlCards, "crdTarjetaMostrar");
        }
        else {JOptionPane.showMessageDialog(null, "ERROR EN LOS DATOS");} 
        
        
        
        
        
        
    }//GEN-LAST:event_btnSacaTarjetaPropiaMouseClicked

    private void txtSacaCodigoTKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSacaCodigoTKeyTyped
        char c= evt.getKeyChar();
        if (c>'9' || c<'0')
        { evt.consume();
        }  
    }//GEN-LAST:event_txtSacaCodigoTKeyTyped

    private void txtContraseñaPTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtContraseñaPTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtContraseñaPTActionPerformed
    public boolean minimo6Boleto(String dato)
    {   int x = Integer.parseInt(dato);
        if (x < 7) 
        { return true;}
        else return false;
    }

    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(proyectoMiTeleferico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(proyectoMiTeleferico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(proyectoMiTeleferico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(proyectoMiTeleferico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        proyectoMiTeleferico pt = new proyectoMiTeleferico();
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new proyectoMiTeleferico().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bntRecarga;
    private javax.swing.JButton btnAceBol;
    private javax.swing.JButton btnAceptarCTM;
    private javax.swing.JButton btnAceptarRTA;
    private javax.swing.JButton btnAceptarRTMoney;
    private javax.swing.JButton btnBoleto;
    private javax.swing.JButton btnCabinas;
    private javax.swing.JButton btnFacturaListo;
    private javax.swing.JButton btnM1;
    private javax.swing.JButton btnM3;
    private javax.swing.JButton btnM4;
    private javax.swing.JButton btnM5;
    private javax.swing.JButton btnMostarRDD;
    private javax.swing.JButton btnMostrarSBT;
    private javax.swing.JButton btnMostrarUDT;
    private javax.swing.JButton btnMostrarUDTigo;
    private javax.swing.JButton btnPT;
    private javax.swing.JButton btnPlataformaMapa;
    private javax.swing.JButton btnRTM;
    private javax.swing.JButton btnSacaAceptar2;
    private javax.swing.JButton btnSacaAceptarBole;
    private javax.swing.JButton btnSacaBT;
    private javax.swing.JButton btnSacaTSalir;
    private javax.swing.JButton btnSacaTarjetaPropia;
    private javax.swing.JButton btnSacar;
    private javax.swing.JButton btnSacarBoleto;
    private javax.swing.JButton btnSacarTarjeta;
    private javax.swing.JButton btnSalirBol;
    private javax.swing.JButton btnSalirMapa;
    private javax.swing.JButton btnSalirRecar;
    private javax.swing.JButton btnSalirTar;
    private javax.swing.JButton btnTP;
    private javax.swing.JButton btnTarjetaListo;
    private javax.swing.JComboBox<String> cbxParadas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JLabel lblMenuTitle;
    private javax.swing.JLabel lblMenuTitle1;
    private javax.swing.JLabel lblMenuTitle2;
    private javax.swing.JLabel lblMenuTitle3;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblTitle1;
    private javax.swing.JPanel pnlCards;
    private javax.swing.JPanel pnlCompraBoleto;
    private javax.swing.JPanel pnlComprarTarjeta;
    private javax.swing.JPanel pnlCrearTigoMoney;
    private javax.swing.JPanel pnlEmpleadosTitle1;
    private javax.swing.JPanel pnlEmpleadosTitle2;
    private javax.swing.JPanel pnlEmpleadosTitle5;
    private javax.swing.JPanel pnlEmpleadosTitle6;
    private javax.swing.JPanel pnlFacturaBol;
    private javax.swing.JPanel pnlHeader;
    private javax.swing.JPanel pnlInicio;
    private javax.swing.JPanel pnlMapa;
    private javax.swing.JPanel pnlMenu;
    private javax.swing.JPanel pnlMostrarSacarBoletoTarjeta;
    private javax.swing.JPanel pnlMostrarUsuariosTarjeta;
    private javax.swing.JPanel pnlMostrarUsuariosTigoMoney;
    private javax.swing.JPanel pnlPlataformaParaSacarBoletos;
    private javax.swing.JPanel pnlRecargaCuentaTigoMoney;
    private javax.swing.JPanel pnlRecargaTarjeta;
    private javax.swing.JPanel pnlRegistroDelDia;
    private javax.swing.JPanel pnlSacaBoleto;
    private javax.swing.JPanel pnlSacaTarjeta;
    private javax.swing.JPanel pnlTarjetaPropia;
    private javax.swing.JPanel pnpMenuTitle;
    private javax.swing.JPanel pnpMenuTitle1;
    private javax.swing.JPanel pnpMenuTitle2;
    private javax.swing.JPanel pnpMenuTitle3;
    private javax.swing.JTable tblRDD;
    private javax.swing.JTable tblSBT;
    private javax.swing.JTable tblUDT;
    private javax.swing.JTable tblUDTigo;
    private javax.swing.JTextField txtCIPT;
    private javax.swing.JTextField txtCTMCEL;
    private javax.swing.JTextField txtCTMCI;
    private javax.swing.JTextField txtCTMCSE;
    private javax.swing.JTextField txtCTMM;
    private javax.swing.JTextField txtCTMN;
    private javax.swing.JTextField txtCiBoleto;
    private javax.swing.JTextField txtCiRTA;
    private javax.swing.JTextField txtContraseñaBoleto;
    private javax.swing.JTextField txtContraseñaPT;
    private javax.swing.JTextField txtContraseñaRTA;
    private javax.swing.JTextField txtCostoBoleto;
    private javax.swing.JTextField txtFacturaCCC;
    private javax.swing.JTextField txtFacturaF;
    private javax.swing.JTextField txtFacturaH;
    private javax.swing.JTextField txtFacturaN;
    private javax.swing.JTextField txtFacturaTotal;
    private javax.swing.JTextField txtMontoPT;
    private javax.swing.JTextField txtMontoRTA;
    private javax.swing.JTextField txtRTMCelular;
    private javax.swing.JTextField txtRTMContraseña;
    private javax.swing.JTextField txtSacaCI;
    private javax.swing.JTextField txtSacaCIT;
    private javax.swing.JTextField txtSacaCodigo;
    private javax.swing.JTextField txtSacaCodigoT;
    private javax.swing.JTextField txtSaldoPT;
    private javax.swing.JTextField txtTMMonto;
    private javax.swing.JTextField txtTarjetaCIOK;
    private javax.swing.JTextField txtTarjetaFechaOK;
    private javax.swing.JTextField txtTarjetaNombreOK;
    // End of variables declaration//GEN-END:variables
}
