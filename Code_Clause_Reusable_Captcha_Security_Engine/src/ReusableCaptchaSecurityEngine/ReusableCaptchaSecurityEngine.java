package ReusableCaptchaSecurityEngine;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

@SuppressWarnings("serial")
public class ReusableCaptchaSecurityEngine extends JFrame {

    private JLabel captchaLabel;
    private JTextField captchaTextField;
    private JButton generateButton;
    private String generatedCaptcha;

    public ReusableCaptchaSecurityEngine() {
        setTitle("Captcha Generator");
        setSize(600, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        captchaLabel = new JLabel();
        captchaLabel.setFont(new Font("Arial", Font.BOLD, 20));
        captchaLabel.setForeground(Color.RED);
        captchaTextField = new JTextField(10);
        generateButton = new JButton("Generate Captcha");
        generateButton.setForeground(Color.DARK_GRAY);
        generateButton.setFont(new Font("Arial", Font.BOLD, 20));

        generateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                generatedCaptcha = generateCaptcha();
                captchaLabel.setText(generatedCaptcha);
            }
        });

        JPanel panel = new JPanel();
        panel.add(captchaLabel);
        panel.add(captchaTextField);
        panel.add(generateButton);

        add(panel);
    }

    private String generateCaptcha() {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder captcha = new StringBuilder();
        Random rnd = new Random();

        for (int i = 0; i < 6; i++) {
            char c = characters.charAt(rnd.nextInt(characters.length()));
            captcha.append(c);
        }

        return captcha.toString();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ReusableCaptchaSecurityEngine().setVisible(true);
            }
        });
    }
}