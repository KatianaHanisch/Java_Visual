import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

class RoundedButton extends JButton {
    public RoundedButton(String label) {
        super(label);
        setContentAreaFilled(false);
        setFocusPainted(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        if (getModel().isArmed()) {
            g.setColor(Color.DARK_GRAY);
        } else {
            g.setColor(getBackground());
        }

        g.fillRoundRect(0, 0, getWidth(), getHeight(), 10, 10);

        super.paintComponent(g);
    }

    @Override
    protected void paintBorder(Graphics g) {
    }
}

public class Cadastro extends JFrame implements ActionListener {
    private JLabel labelNome, labelCpf, labelEmail, labelEndereco, labelTelefone, labelBairro;
    private JTextArea campoNome, campoEmail, campoEndereco, campoBairro;
    private JFormattedTextField campoCpf, campoTelefone;
    private JButton botaoEnviar, botaoLimpar;

    public Cadastro() {
        setTitle("Tela de Cadastro");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = getContentPane();
        container.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 10, 5, 10);
        gbc.anchor = GridBagConstraints.WEST;

        Font labelFont = new Font("Arial", Font.BOLD, 14);
        Font fieldFont = new Font("Arial", Font.PLAIN, 14);

        labelNome = new JLabel("Nome:");
        labelNome.setFont(labelFont);
        gbc.gridx = 0;
        container.add(labelNome, gbc);

        labelCpf = new JLabel("CPF:");
        labelCpf.setFont(labelFont);
        gbc.gridy = 1;
        container.add(labelCpf, gbc);

        labelEmail = new JLabel("Email:");
        labelEmail.setFont(labelFont);
        gbc.gridy = 2;
        container.add(labelEmail, gbc);

        labelTelefone = new JLabel("Telefone:");
        labelTelefone.setFont(labelFont);
        gbc.gridy = 3;
        container.add(labelTelefone, gbc);

        labelEndereco = new JLabel("Endereço:");
        labelEndereco.setFont(labelFont);
        gbc.gridy = 4;
        container.add(labelEndereco, gbc);

        labelBairro = new JLabel("Bairro:");
        labelBairro.setFont(labelFont);
        gbc.gridy = 5;
        container.add(labelBairro, gbc);

        campoNome = new JTextArea(1, 40);
        campoNome.setFont(fieldFont);
        campoNome.setLineWrap(true);
        campoNome.setWrapStyleWord(true);
        campoNome.setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(Color.decode("#d6d6d6"), 1),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        gbc.gridx = 1;
        gbc.gridy = 0;
        container.add(campoNome, gbc);

        try {
            MaskFormatter cpfMask = new MaskFormatter("###.###.###-##");
            campoCpf = new JFormattedTextField(cpfMask);
            campoCpf.setColumns(40);
        } catch (java.text.ParseException e) {
            e.printStackTrace();
        }
        campoCpf.setFont(fieldFont);
        campoCpf.setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(Color.decode("#d6d6d6"), 1),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        gbc.gridy = 1;
        container.add(campoCpf, gbc);

        campoEmail = new JTextArea(1, 40);
        campoEmail.setFont(fieldFont);
        campoEmail.setLineWrap(true);
        campoEmail.setWrapStyleWord(true);
        campoEmail.setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(Color.decode("#d6d6d6"), 1),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        gbc.gridy = 2;
        container.add(campoEmail, gbc);

        try {
            MaskFormatter telefoneMask = new MaskFormatter("(##) #####-####"); // Máscara de telefone
            campoTelefone = new JFormattedTextField(telefoneMask);
            campoTelefone.setColumns(40); // Define o mesmo número de colunas que os outros campos
        } catch (java.text.ParseException e) {
            e.printStackTrace();
        }
        campoTelefone.setFont(fieldFont);
        campoTelefone.setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(Color.decode("#d6d6d6"), 1),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        gbc.gridy = 3;
        container.add(campoTelefone, gbc);

        campoEndereco = new JTextArea(1, 40);
        campoEndereco.setFont(fieldFont);
        campoEndereco.setLineWrap(true);
        campoEndereco.setWrapStyleWord(true);
        campoEndereco.setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(Color.decode("#d6d6d6"), 1),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        gbc.gridy = 4;
        container.add(campoEndereco, gbc);

        campoBairro = new JTextArea(1, 40);
        campoBairro.setFont(fieldFont);
        campoBairro.setLineWrap(true);
        campoBairro.setWrapStyleWord(true);
        campoBairro.setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(Color.decode("#d6d6d6"), 1),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        gbc.gridy = 5;
        container.add(campoBairro, gbc);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.setBorder(new EmptyBorder(20, 0, 0, 0));

        botaoEnviar = new RoundedButton("Cadastrar");
        botaoEnviar.addActionListener(this);
        botaoEnviar.setForeground(Color.WHITE);
        botaoEnviar.setBackground(Color.DARK_GRAY);
        botaoEnviar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        botaoEnviar.setPreferredSize(new Dimension(120, 35));

        botaoLimpar = new RoundedButton("Limpar");
        botaoLimpar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limparCampos();
            }
        });
        botaoLimpar.setForeground(Color.WHITE);
        botaoLimpar.setBackground(Color.DARK_GRAY);
        botaoLimpar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        botaoLimpar.setPreferredSize(new Dimension(120, 35));

        buttonPanel.add(botaoEnviar);
        buttonPanel.add(botaoLimpar);
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 2;
        container.add(buttonPanel, gbc);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == botaoEnviar) {
            if (camposEstaoPreenchidos()) {
                exibirInformacoes();
            } else {
                JOptionPane.showMessageDialog(this, "Preencha todos os campos antes de enviar.", "Erro",
                        JOptionPane.ERROR_MESSAGE);
            }
        } else if (event.getSource() == botaoLimpar) {
            limparCampos();
        }
    }

    private boolean camposEstaoPreenchidos() {
        return !campoNome.getText().isEmpty() && !campoCpf.getText().isEmpty() && !campoEmail.getText().isEmpty()
                && !campoTelefone.getText().isEmpty() && !campoEndereco.getText().isEmpty()
                && !campoBairro.getText().isEmpty();
    }

    private void limparCampos() {
        campoNome.setText("");
        campoCpf.setValue(null);
        campoEmail.setText("");
        campoTelefone.setValue(null);
        campoEndereco.setText("");
        campoBairro.setText("");
    }

    private void exibirInformacoes() {
        String nome = campoNome.getText();
        String cpf = campoCpf.getText();
        String email = campoEmail.getText();
        String telefone = campoTelefone.getText();
        String endereco = campoEndereco.getText();
        String bairro = campoBairro.getText();

        String mensagem = "Informações cadastradas:\n\n" + "Nome: " + nome + "\n" + "CPF: " + cpf + "\n" + "Email: "
                + email
                + "\n" + "Telefone: " + telefone + "\n" + "Endereço: " + endereco + "\n" + "Bairro: " + bairro;

        JTextArea textArea = new JTextArea(mensagem);
        textArea.setFont(new Font("Arial", Font.BOLD, 14));
        textArea.setWrapStyleWord(true);
        textArea.setLineWrap(true);
        textArea.setOpaque(false);
        textArea.setEditable(false);
        textArea.setFocusable(false);

        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new Dimension(400, 200));

        JOptionPane.showMessageDialog(this, scrollPane, "Informações Enviadas", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Cadastro cadastro = new Cadastro();
        });
    }
}
