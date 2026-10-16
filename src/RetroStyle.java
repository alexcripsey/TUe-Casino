import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;

/**
 * Shared arcade cabinet styling for the casino screens.
 */
public final class RetroStyle {
    public static final Color CABINET = new Color(18, 24, 46);
    public static final Color PANEL = new Color(29, 39, 68);
    public static final Color GOLD = new Color(255, 204, 70);
    public static final Color MINT = new Color(91, 231, 190);
    public static final Color INK = new Color(19, 25, 44);
    private static final Color MUTED_BLUE = new Color(75, 96, 140);

    private RetroStyle() {
    }

    public static void styleScreen(JPanel root) {
        root.setBackground(CABINET);
        root.setBorder(new CompoundBorder(new LineBorder(GOLD, 3), new EmptyBorder(14, 18, 14, 18)));
        styleChildren(root);
    }

    private static void styleChildren(Container parent) {
        for (Component component : parent.getComponents()) {
            if (component instanceof JPanel) {
                component.setBackground(CABINET);
                styleChildren((Container) component);
            } else if (component instanceof JLabel) {
                JLabel label = (JLabel) component;
                label.setFont(new Font(Font.MONOSPACED, Font.BOLD, 13));
                label.setForeground(MINT);
            } else if (component instanceof JTextField) {
                JTextField field = (JTextField) component;
                field.setFont(new Font(Font.MONOSPACED, Font.BOLD, 15));
                field.setForeground(GOLD);
                field.setCaretColor(GOLD);
                field.setBackground(INK);
                field.setBorder(new CompoundBorder(new LineBorder(GOLD, 2), new EmptyBorder(6, 8, 6, 8)));
            } else if (component instanceof JComboBox) {
                JComboBox<?> choice = (JComboBox<?>) component;
                choice.setFont(new Font(Font.MONOSPACED, Font.BOLD, 12));
                choice.setForeground(GOLD);
                choice.setBackground(INK);
                choice.setBorder(new LineBorder(MUTED_BLUE, 2));
            } else if (component instanceof JButton) {
                styleButton((JButton) component);
            } else if (component instanceof Container) {
                styleChildren((Container) component);
            }
        }
    }

    public static void styleButton(JButton button) {
        button.setFont(new Font(Font.MONOSPACED, Font.BOLD, 12));
        button.setForeground(INK);
        button.setBackground(GOLD);
        button.setFocusPainted(false);
        button.setOpaque(true);
        button.setBorder(new CompoundBorder(new LineBorder(new Color(255, 231, 151), 2),
                new EmptyBorder(7, 10, 7, 10)));
        button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        button.getModel().addChangeListener(e -> {
            ButtonModel model = (ButtonModel) e.getSource();
            button.setBackground(model.isPressed() ? MINT : model.isRollover()
                    ? new Color(255, 222, 112) : GOLD);
        });
    }

    public static void styleTitle(JLabel title, String text) {
        title.setText(text);
        title.setFont(new Font(Font.MONOSPACED, Font.BOLD, 23));
        title.setForeground(GOLD);
        title.setBorder(new EmptyBorder(0, 0, 12, 0));
    }

    public static void styleDisplay(JLabel display, String text) {
        display.setText(text);
        display.setFont(new Font(Font.MONOSPACED, Font.BOLD, 23));
        display.setForeground(GOLD);
        display.setOpaque(true);
        display.setBackground(PANEL);
        display.setBorder(new CompoundBorder(new LineBorder(MUTED_BLUE, 2),
                new EmptyBorder(36, 20, 36, 20)));
    }
}
