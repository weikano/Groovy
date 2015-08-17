import javax.swing.*
import java.awt.*
import java.awt.event.*

def frame = new JFrame(size: [300,300],layout: new FlowLayout(),defaultCloseOperation: javax.swing.WindowConstants.EXIT_ON_CLOSE)
def button = new JButton("click")
def positionLabel = new JLabel("")
def msgLabel = new JLabel("")
frame.contentPane.add(button)
frame.contentPane.add(positionLabel)
frame.contentPane.add(msgLabel)

button.addActionListener(
        {JOptionPane.showMessageDialog(frame,"You Clicked!")} as ActionListener
)
displayMouseLocation = {positionLabel.setText("$it.x, $it.y")}
frame.addMouseListener(displayMouseLocation as MouseListener)
frame.addMouseMotionListener(displayMouseLocation as MouseMotionListener)

handleFocus = [
        focusGained : {msgLabel.setText("Good to see you")},
        focusLost : {msgLabel.setText("Come back soon")}
]
button.addFocusListener(handleFocus as FocusListener)
events = ["WindowListener","ComponentListener"]
handler = {msgLabel.setText("$it")}
for(event in events){
    handleImpl = handler.asType(Class.forName("java.awt.event.${event}"))
    frame."add$event"(handleImpl)
}
frame.show()