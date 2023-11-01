import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.EmptyBorder;

class RoundedButton extends JButton {
    public RoundedButton(String label) {
        super(label);
        setContentAreaFilled(false); // Remove o preenchimento do botão
        setFocusPainted(false); // Remove a pintura de foco
    }

    @Override
    protected void paintComponent(Graphics g) {
        if (getModel().isArmed()) {
            g.setColor(Color.DARK_GRAY); // Cor de fundo quando pressionado
        } else {
            g.setColor(getBackground());
        }

        g.fillRoundRect(0, 0, getWidth(), getHeight(), 10, 10);

        super.paintComponent(g);
    }

    @Override
    protected void paintBorder(Graphics g) {
        // Não desenhe a borda padrão
    }
}

public class Cadastro extends JFrame implements ActionListener {
    private JLabel labelNome, labelCpf, labelIdade, labelEndereco;
    private JTextArea campoNome, campoCpf, campoIdade, campoEndereco;
    private JButton botaoEnviar, botaoLimpar;

    public Cadastro() {
        setTitle("Tela de Cadastro");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = getContentPane();
        container.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;

        Font labelFont = new Font("Arial", Font.PLAIN, 14); // Defina a fonte dos rótulos
        Font fieldFont = new Font("Arial", Font.PLAIN, 14); // Defina a fonte dos campos de texto

        labelNome = new JLabel("Nome:");
        labelNome.setFont(labelFont); // Aplica o tamanho da fonte
        gbc.gridx = 0;
        container.add(labelNome, gbc);

        labelCpf = new JLabel("CPF:");
        labelCpf.setFont(labelFont); // Aplica o tamanho da fonte
        gbc.gridy = 1;
        container.add(labelCpf, gbc);

        labelIdade = new JLabel("Idade:");
        labelIdade.setFont(labelFont); // Aplica o tamanho da fonte
        gbc.gridy = 2;
        container.add(labelIdade, gbc);

        labelEndereco = new JLabel("Endereço:");
        labelEndereco.setFont(labelFont); // Aplica o tamanho da fonte
        gbc.gridy = 3;
        container.add(labelEndereco, gbc);

        campoNome = new JTextArea(1, 40);
        campoNome.setMargin(new Insets(2, 5, 2, 0)); // Aplica o padding à esquerda
        campoNome.setFont(fieldFont); // Aplica o tamanho da fonte
        campoNome.setLineWrap(true); // Quebra de linha automática
        campoNome.setWrapStyleWord(true); // Quebra de linha entre palavras
        campoNome.setBorder(new LineBorder(Color.decode("#d6d6d6"), 1)); // Adiciona a borda
        gbc.gridx = 1;
        gbc.gridy = 0;
        container.add(campoNome, gbc);

        campoCpf = new JTextArea(1, 40);
        campoCpf.setMargin(new Insets(2, 5, 2, 0)); // Aplica o padding à esquerda
        campoCpf.setFont(fieldFont); // Aplica o tamanho da fonte
        campoCpf.setLineWrap(true); // Quebra de linha automática
        campoCpf.setWrapStyleWord(true); // Quebra de linha entre palavras
        campoCpf.setBorder(new LineBorder(Color.decode("#d6d6d6"), 1)); // Adiciona a borda
        gbc.gridy = 1;
        container.add(campoCpf, gbc);

        campoIdade = new JTextArea(1, 40);
        campoIdade.setMargin(new Insets(5, 10, 2, 0)); // Aplica o padding à esquerda
        campoIdade.setFont(fieldFont); // Aplica o tamanho da fonte
        campoIdade.setLineWrap(true); // Quebra de linha automática
        campoIdade.setWrapStyleWord(true); // Quebra de linha entre palavras
        campoIdade.setBorder(new LineBorder(Color.decode("#d6d6d6"), 1)); // Adiciona a borda
        gbc.gridy = 2;
        container.add(campoIdade, gbc);

        campoEndereco = new JTextArea(1, 40);
        campoEndereco.setMargin(new Insets(2, 5, 2, 0)); // Aplica o padding à esquerda
        campoEndereco.setFont(fieldFont); // Aplica o tamanho da fonte
        campoEndereco.setLineWrap(true); // Quebra de linha automática
        campoEndereco.setWrapStyleWord(true); // Quebra de linha entre palavras
        campoEndereco.setBorder(new LineBorder(Color.decode("#d6d6d6"), 1)); // Adiciona a borda
        gbc.gridy = 3;
        container.add(campoEndereco, gbc);

        // Crie um painel para os botões "Enviar" e "Limpar Campos"
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        buttonPanel.setBorder(new EmptyBorder(20, 0, 0, 0)); // Margem superior de 20px

        botaoEnviar = new RoundedButton("Enviar");
        botaoEnviar.addActionListener(this);
        botaoEnviar.setForeground(Color.WHITE); // Cor do texto
        botaoEnviar.setBackground(Color.DARK_GRAY); // Cor de fundo
        botaoEnviar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)); // Cursor de mão
        botaoEnviar.setPreferredSize(new Dimension(120, 40)); // Aumenta o tamanho do botão

        botaoLimpar = new RoundedButton("Limpar");
        botaoLimpar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Adicione a lógica para limpar os campos aqui
                campoNome.setText("");
                campoCpf.setText("");
                campoIdade.setText("");
                campoEndereco.setText("");
            }
        });
        botaoLimpar.setForeground(Color.WHITE); // Cor do texto
        botaoLimpar.setBackground(Color.DARK_GRAY); // Cor de fundo
        botaoLimpar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)); // Cursor de mão
        botaoLimpar.setPreferredSize(new Dimension(120, 40)); // Aumenta o tamanho do botão

        buttonPanel.add(botaoEnviar);
        buttonPanel.add(botaoLimpar);
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        container.add(buttonPanel, gbc);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        String nome = campoNome.getText();
        String cpf = campoCpf.getText();
        int idade = Integer.parseInt(campoIdade.getText());
        String endereco = campoEndereco.getText();

        // Adicione aqui o código para validar e salvar os dados do formulário
    }

    public static void main(String[] args) {
        Cadastro cadastro = new Cadastro();
    }
}
