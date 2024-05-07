import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import static java.lang.System.*;

public class VistaOrbita extends JFrame {
    public VistaOrbita() {
        iniciarComponentes();
        iniciarControl();
        return;
    }
    private void iniciarComponentes() {
        contenedor=getContentPane();
        base=new JLabel();
        nave = new JLabel();
        luna = new JLabel();
        espacio = new JLabel();
        botonA = new JButton();
        botonB = new JButton();
        botonC = new JButton();
        botonD = new JButton();
        botonE = new JButton();
        campoEstado = new JLabel();

        nave.setSize(28, 28);
        nave.setLocation(800, 500);
        nave.setIcon(imagenNave);
        nave.setVisible(false);
        nave.setHorizontalAlignment(SwingConstants.CENTER);
        nave.setToolTipText("");
        nave.setAlignmentY(0.0F);
        nave.setFocusable(false);
        nave.setIconTextGap(0);
        nave.setInheritsPopupMenu(false);
        nave.setOpaque(false);
        nave.setRequestFocusEnabled(false);
        nave.setVerifyInputWhenFocusTarget(false);

        luna.setSize(30, 30);
        luna.setLocation(600, 250);
        luna.setIcon(imagenLuna);
        luna.setHorizontalAlignment(SwingConstants.CENTER);
        luna.setToolTipText("");
        luna.setAlignmentY(0.0F);
        luna.setFocusable(false);
        luna.setIconTextGap(0);
        luna.setInheritsPopupMenu(false);
        luna.setOpaque(false);
        luna.setRequestFocusEnabled(false);
        luna.setVerifyInputWhenFocusTarget(false);

        espacio.setSize(1024, 720);
        espacio.setLocation(margen, margen);
        espacio.setIcon(imagenEspacio);
        espacio.setHorizontalAlignment(SwingConstants.CENTER);
        espacio.setAlignmentY(0.0F);
        espacio.setBorder(BorderFactory.createEtchedBorder());
        espacio.setFocusable(false);
        espacio.setIconTextGap(0);
        espacio.setInheritsPopupMenu(false);
        espacio.setOpaque(true);
        espacio.setRequestFocusEnabled(false);
        espacio.setVerifyInputWhenFocusTarget(false);

        base.setSize(espacio.getWidth()+campoEstado.getWidth()+3*margen, espacio.getHeight()+2*margen+margenCabecera);
        base.setLocation(0, 0);
        base.setHorizontalAlignment(SwingConstants.CENTER);
        base.setAlignmentY(0.0F);
        base.setBorder(BorderFactory.createEtchedBorder());
        base.setFocusable(false);
        base.setIconTextGap(0);
        base.setInheritsPopupMenu(false);
        base.setOpaque(true);
        base.setRequestFocusEnabled(false);
        base.setVerifyInputWhenFocusTarget(false);

        botonA.setText("acelerar nave");
        botonA.setActionCommand("pulsandoBotonA");
        botonA.setAlignmentY(0.0F);
        botonA.setFocusPainted(false);
        botonA.setSize(180, 40);
        botonA.setLocation(espacio.getWidth()+2*margen, margen);
        botonA.setRequestFocusEnabled(false);
        botonA.setRolloverEnabled(false);
        botonA.setVerifyInputWhenFocusTarget(false);
        botonA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAActionPerformed(evt);
            }
        });

        botonB.setText("frenar nave");
        botonB.setActionCommand("pulsandoBotonB");
        botonB.setAlignmentY(0.0F);
        botonB.setFocusPainted(false);
        botonB.setSize(180, 40);
        botonB.setLocation(botonA.getX(), botonA.getHeight()+botonA.getY()+margen/2);
        botonB.setRequestFocusEnabled(false);
        botonB.setRolloverEnabled(false);
        botonB.setVerifyInputWhenFocusTarget(false);
        botonB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBActionPerformed(evt);
            }
        });

        botonC.setText("lanzar nave");
        botonC.setActionCommand("pulsandoBotonC");
        botonC.setAlignmentY(0.0F);
        botonC.setEnabled(true);
        botonC.setFocusPainted(false);
        botonC.setSize(180, 40);
        botonC.setLocation(botonA.getX(), botonA.getHeight()+botonB.getY()+margen/2);
        botonC.setRequestFocusEnabled(false);
        botonC.setRolloverEnabled(false);
        botonC.setVerifyInputWhenFocusTarget(false);
        botonC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCActionPerformed(evt);
            }
        });

        botonD.setText("pausar");
        botonD.setActionCommand("pulsandoBotonD");
        botonD.setAlignmentY(0.0F);
        botonD.setEnabled(true);
        botonD.setFocusPainted(false);
        botonD.setSize(180, 40);
        botonD.setLocation(botonA.getX(), botonA.getHeight()+botonC.getY()+margen/2);
        botonD.setRequestFocusEnabled(false);
        botonD.setRolloverEnabled(false);
        botonD.setVerifyInputWhenFocusTarget(false);
        botonD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonDActionPerformed(evt);
            }
        });

        botonE.setText("");
        botonE.setActionCommand("pulsandoBotonE");
        botonE.setAlignmentY(0.0F);
        botonE.setEnabled(false);
        botonE.setFocusPainted(false);
        botonE.setSize(180, 40);
        botonE.setLocation(botonA.getX(), botonA.getHeight()+botonD.getY()+margen/2);
        botonE.setRequestFocusEnabled(false);
        botonE.setRolloverEnabled(false);
        botonE.setVerifyInputWhenFocusTarget(false);
        botonE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEActionPerformed(evt);
            }
        });

        campoEstado.setHorizontalAlignment(SwingConstants.LEFT);
        campoEstado.setText("");
        campoEstado.setVerticalAlignment(SwingConstants.TOP);
        campoEstado.setAlignmentY(0.0F);
        campoEstado.setBorder(BorderFactory.createEmptyBorder());
        campoEstado.setFocusable(false);
        campoEstado.setHorizontalTextPosition(SwingConstants.LEFT);
        campoEstado.setInheritsPopupMenu(false);
        campoEstado.setSize(botonA.getWidth()+(int) (1.5*margen), 3*botonA.getHeight());
        campoEstado.setLocation(botonA.getX(), botonA.getHeight()+botonE.getY()+2*margen);
        campoEstado.setRequestFocusEnabled(false);
        campoEstado.setVerifyInputWhenFocusTarget(false);
        campoEstado.setVerticalTextPosition(SwingConstants.TOP);
        setResizable(false);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Simulador de órbitas - © 2024 Carlos Grasa Lambea");
        setIconImage(iconoDesarrollador);
        setAutoRequestFocus(false);
        setFocusCycleRoot(false);
        setResizable(false);
        setSize(espacio.getWidth()+campoEstado.getWidth()+3*margen, espacio.getHeight()+2*margen+margenCabecera);
        setMaximumSize(new Dimension(getWidth(), getHeight()));
        setMinimumSize(new Dimension(getWidth(), getHeight()));
        setPreferredSize(new Dimension(getWidth(), getHeight()));

        contenedor.add(campoEstado);
        contenedor.add(botonA);
        contenedor.add(botonB);
        contenedor.add(botonC);
        contenedor.add(botonD);
        contenedor.add(botonE);
        contenedor.add(nave);
        contenedor.add(luna);
        contenedor.add(espacio);
        contenedor.add(base);

        pack();
        return;
    }
    public static void main(String args[]) {
        try {
            UIManager.LookAndFeelInfo[] installedLookAndFeels=UIManager.getInstalledLookAndFeels();
            for (int idx=0; idx<installedLookAndFeels.length; idx++)
                if ("Nimbus".equals(installedLookAndFeels[idx].getName())) {
                    UIManager.setLookAndFeel(installedLookAndFeels[idx].getClassName());
                    break;
                }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VistaOrbita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaOrbita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaOrbita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaOrbita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaOrbita().setVisible(true);
            }
        });
        return;
    }

    // campos ---------------------------------------------------------------------------------------
    Image iconoDesarrollador=new ImageIcon(getClass().getResource("logodesarrollador64.png")).getImage();
    Icon imagenNave=new ImageIcon(getClass().getResource("nave2.png"));
    Icon imagenLuna=new ImageIcon(getClass().getResource("luna2.png"));
    Icon imagenEspacio=new ImageIcon(getClass().getResource("espacio2.png"));
    Container contenedor;
    JButton botonA;
    JButton botonB;
    JButton botonC;
    JButton botonD;
    JButton botonE;
    JLabel base;
    JLabel campoEstado;
    JLabel espacio;
    JLabel luna;
    JLabel nave;
    int margen=12; // px
    int margenCabecera=38; // px
    double xTierra; // px
    double yTierra; // px
    double radioTierra=150.0; // px
    double gravitacionTierra=4.0; // px/seg²
    double radioLuna=15.0; // px
    double radioOrbitaLuna; // px
    double periodoLuna=60.0; // seg
    double anguloLuna=0.0; // rad
    double gravitacionLuna; // px/seg²
    double xLuna; // px
    double yLuna; // px
    double radioNave=14.0; // px
    double vxNave; // px/seg
    double vyNave; // px/seg
    double xNave; // px
    double yNave; // px
    double radioMeteorito; // px
    int lapso=33; // intervalo programado de actualización de estado en ms
    long instanteRegistrado; // tiempo anterior registrado para cálculos de movimiento
    double tiempoTranscurrido; // intervalo real de tiempo transcurrido
    Timer timer;
    boolean esActivo=true; // simulador está o no en funcionamiento activo
    int margenVisibilidad=8; // margen para visibilidad de los objetos en el espacio
    int xMin; // mínimo x para visibilidad en espacio
    int xMax; // máximo x para visibilidad en espacio
    int yMin; // mínimo y para visibilidad en espacio
    int yMax; // máximo y para visibilidad en espacio

    // métodos --------------------------------------------------------------------------------------
    private void botonAActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }
    private void botonBActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }
    private void botonCActionPerformed(java.awt.event.ActionEvent evt) {
        lanzarNave();
        return;
    }
    private void botonDActionPerformed(java.awt.event.ActionEvent evt) {
        if (esActivo) {
            botonD.setText("continuar");
            esActivo=false;
        } else {
            botonD.setText("pausar");
            esActivo=true;
        }
        return;
    }
    private void botonEActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }
    public void iniciarControl() {
        xMin=espacio.getX()+margenVisibilidad;
        xMax=espacio.getX()+espacio.getWidth()-margenVisibilidad;
        yMin=espacio.getY()+margenVisibilidad;
        yMax=espacio.getY()+espacio.getHeight()-margenVisibilidad;
        xTierra= espacio.getX()+espacio.getWidth()/2.0;
        yTierra= espacio.getY()+espacio.getHeight()/2.0;
        radioOrbitaLuna=espacio.getHeight()*2.0/5.0;
        xLuna=xTierra+radioOrbitaLuna;
        yLuna=yTierra;
        gravitacionLuna=gravitacionTierra/50.0;
        timer = new Timer(lapso, new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                registrarInstante();
                actualizarLuna();
                actualizarNave();
                return;
            }
        });
        timer.start();

        return;
    }
    public void actualizarLuna() {
        if (!esActivo)
            return;
        anguloLuna-=360.0/periodoLuna*tiempoTranscurrido;
        if (anguloLuna<0)
            anguloLuna+=360;
        double rads=anguloLuna*Math.PI/180.0;
        luna.setLocation((int) (xTierra+radioOrbitaLuna*Math.cos(rads)), (int) (yTierra+radioOrbitaLuna*Math.sin(rads)));
        return;
    }
    public void actualizarNave() {
        if (!esActivo)
            return;
        double distanciaCuadradoTierra=(xTierra-xNave)*(xTierra-xNave)+(yTierra-yNave)*(yTierra-yNave);
        double aceleracionTierra=gravitacionTierra/((xTierra-xNave)*(xTierra-xNave)+(yTierra-yNave)*(yTierra-yNave));

        return;
    }

    public void registrarInstante() {
        long antes=instanteRegistrado;
        instanteRegistrado=currentTimeMillis();
        tiempoTranscurrido=(double) (instanteRegistrado-antes)/1000.0;
        return;
    }
    public void lanzarNave() {
        xNave=xTierra;
        yNave=yTierra/2.0;
        vxNave=0;
        vyNave=-20.0;
        nave.setLocation((int) xNave, (int) yNave);
        nave.setVisible(true);
        return;
    }
}

/*
		timer = new Timer(lapso, new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				moverse();
				comprobarImpacto();
				return;
			}
		});
		timer.start();
 */