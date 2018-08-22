package br.org.queryeditor.forms.formsutil;

/**
 * Função<br>
 *
 * created 00/00/2018<br>
 * lastModified 00/00/2018
 *
 * @author Israel Gomes
 * @version 1.0
 * @since 1.0
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.plaf.basic.BasicButtonUI;

public class ButtonTabComponent extends JPanel {

    private final JTabbedPane pane;
    private static ImageIcon BOTAO_FECHAR;
    private static ImageIcon BOTAO_FECHAR_RED;
    private final ViewUtil viewUtil;
    
    public ButtonTabComponent(final JTabbedPane pane) {
        super(new FlowLayout(FlowLayout.LEFT, 0, 0));
        this.pane = pane;
        this.viewUtil = new ViewUtil();
        
        ButtonTabComponent.BOTAO_FECHAR = this.viewUtil.getImageIcon("fechar.png");
        ButtonTabComponent.BOTAO_FECHAR_RED = this.viewUtil.getImageIcon("fechar_red.png");
        
        setOpaque(false);
        JLabel label = new JLabel() {
            @Override
            public String getText() {
                int i = pane.indexOfTabComponent(ButtonTabComponent.this);
                if (i != -1) {
                    return pane.getTitleAt(i);
                }
                return null;
            }
        };
        add(label);
        //adiciona mais espaço entre a label e o botão
        label.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 5));
        //tab button
        JButton button = new TabButton();
        add(button);
        //adiciona mais espaço para o topo do componente
        setBorder(BorderFactory.createEmptyBorder(2, 0, 0, 0));
    }

    private class TabButton extends JButton implements ActionListener {

        public TabButton() {
            int size = 17;
            setPreferredSize(new Dimension(size, size));
            setToolTipText("Fechar esta aba!");
            
            //Faz o botão ser igual para todas as Laf's
            setUI(new BasicButtonUI());
            //Torna-o transparente
            setContentAreaFilled(false);
            //Não necessidade de estar com focusable
            setFocusable(false);
            setBorder(BorderFactory.createEtchedBorder());
            setBorderPainted(false);
            //usamos o mesmo listener para todos os botões
            addMouseListener(buttonMouseListener);
            setRolloverEnabled(true);
            //Fecha a guia apropriada, clicando no botão
            addActionListener(this);
            setIcon(BOTAO_FECHAR);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            int i = pane.indexOfTabComponent(ButtonTabComponent.this);
            if (i != -1) {
                pane.remove(i);
            }
        }
    }

    private final static MouseListener buttonMouseListener = new MouseAdapter() {
        @Override
        public void mouseEntered(MouseEvent e) {
            Component component = e.getComponent();
            if (component instanceof AbstractButton) {
                AbstractButton button = (AbstractButton) component;
                button.setIcon(BOTAO_FECHAR_RED);
            }
        }

        @Override
        public void mouseExited(MouseEvent e) {
            Component component = e.getComponent();
            if (component instanceof AbstractButton) {
                AbstractButton button = (AbstractButton) component;
                button.setIcon(BOTAO_FECHAR);
            }
        }
    };
}
