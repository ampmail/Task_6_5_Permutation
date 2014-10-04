import javax.swing.*;

public class viewDialog {
    public static String getSomeText() {
        String text = "";
        JFrame jfrm0 = new JFrame("Input some text");
        do {
            text = JOptionPane.showInputDialog(jfrm0, "Input text: ", new String(""));
        } while (text.isEmpty());
        return text;
    }
    public static void viewData(String msg) {
        JFrame jfrm = new JFrame("Data");
        jfrm.setSize(400, 300);
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JTextArea textArea = new JTextArea(100, 50);
        textArea.setText(msg);
        jfrm.add(textArea);
        jfrm.add(new JScrollPane(textArea));
        jfrm.setVisible(true);
    }
}
