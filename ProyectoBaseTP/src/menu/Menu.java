package menu;

import juego.*;

public class Menu extends javax.swing.JFrame {
	
	private javax.swing.JMenuBar barraMenu;
    private javax.swing.JButton botonIniciarJuego;
    private javax.swing.JButton botonInstrucciones;
    private javax.swing.JLabel etiquetaTitulo;
    private javax.swing.JMenu menuOpciones;
    private javax.swing.JPanel panel;
    private javax.swing.JMenuItem subMenuSalir;
	
    public Menu() {
    	iniciarComponentes();
        this.setLocationRelativeTo(null);
    }

                              
    private void iniciarComponentes() {

        panel = new javax.swing.JPanel();
        etiquetaTitulo = new javax.swing.JLabel();
        botonIniciarJuego = new javax.swing.JButton();
        botonInstrucciones = new javax.swing.JButton();
        barraMenu = new javax.swing.JMenuBar();
        menuOpciones = new javax.swing.JMenu();
        subMenuSalir = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panel.setBackground(new java.awt.Color(0, 0, 0));

        etiquetaTitulo.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 36)); // NOI18N
        etiquetaTitulo.setForeground(new java.awt.Color(255, 255, 255));
        etiquetaTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        etiquetaTitulo.setText("Boss Rabbit - Grupo ... - V1");

        botonIniciarJuego.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        botonIniciarJuego.setText("Iniciar Juego");
        botonIniciarJuego.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonIniciarJuegoActionPerformed(evt);
            }
        });

        botonInstrucciones.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        botonInstrucciones.setText("Instrucciones");
        botonInstrucciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonInstruccionesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(etiquetaTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, 539, Short.MAX_VALUE)
            .addGroup(panelLayout.createSequentialGroup()
                .addGap(181, 181, 181)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botonIniciarJuego)
                    .addComponent(botonInstrucciones))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addGap(89, 89, 89)
                .addComponent(etiquetaTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 80, Short.MAX_VALUE)
                .addComponent(botonIniciarJuego)
                .addGap(86, 86, 86)
                .addComponent(botonInstrucciones)
                .addGap(130, 130, 130))
        );

        menuOpciones.setText("Opciones");

        subMenuSalir.setText("Salir");
        subMenuSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subMenuSalirActionPerformed(evt);
            }
        });
        menuOpciones.add(subMenuSalir);

        barraMenu.add(menuOpciones);
        //barraMenu.setBackground(new java.awt.Color(230,240,240));
        setJMenuBar(barraMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }                       

    private void botonIniciarJuegoActionPerformed(java.awt.event.ActionEvent evt) {                                                  
        this.dispose();
        Juego juego=new Juego();
        
    }                                                 

    private void botonInstruccionesActionPerformed(java.awt.event.ActionEvent evt) {                                                   
        MenuInstrucciones instrucciones = new MenuInstrucciones(this,true);
        instrucciones.setVisible(true);
    }                                                  

    private void subMenuSalirActionPerformed(java.awt.event.ActionEvent evt) {                                             
        System.exit(0);
    }                                            

    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }              
}
