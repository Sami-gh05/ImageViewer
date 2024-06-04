import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Scanner;


public class ImageViewerGUI extends JFrame implements ActionListener{
    JButton selectFileButton;
    JButton showImageButton;
    JButton resizeButton;
    JButton grayscaleButton;
    JButton brightnessButton;
    JButton closeButton;
    JButton showResizeButton;
    JButton showBrightnessButton;
    JButton backButton;
    JTextField widthTextField;
    JTextField heightTextField;
    JTextField brightnessTextField;
    String filePath = "F:\\Wallpapers";
    File file;
    JFileChooser fileChooser = new JFileChooser(filePath);
    int h = 900;
    int w = 1200;
    float brightenFactor = 1;

    //fields that I declared myself to make my code better
    Font buttonFont = new Font("Cooper Black", Font.PLAIN, 35);

    ImageViewerGUI(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Image Viewer");
        this.setSize(700, 300);
        this.setVisible(true);
        this.setResizable(true);

        mainPanel();
    }

    public void mainPanel(){
        // Create main panel for adding to Frame
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        // Create Grid panel for adding buttons to it, then add it all to main panel
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new GridLayout(3, 2));
        buttonsPanel.setSize(500,200);

        //Giving a name to our buttons of buttonspanel(in main panel)
        selectFileButton = new JButton("Choose Image");
        showImageButton = new JButton("Show Image");
        brightnessButton = new JButton("Brightness");
        grayscaleButton = new JButton("Gray Scale");
        resizeButton = new JButton("Resize");
        closeButton = new JButton("Exit");

        //setting font for buttons of main panel:
        selectFileButton.setFont(buttonFont);
        showImageButton.setFont(buttonFont);
        brightnessButton.setFont(buttonFont);
        grayscaleButton.setFont(buttonFont);
        resizeButton.setFont(buttonFont);
        closeButton.setFont(buttonFont);

        //Adding action listener to buttons
        selectFileButton.addActionListener(this);
        showImageButton.addActionListener(this);
        brightnessButton.addActionListener(this);
        grayscaleButton.addActionListener(this);
        resizeButton.addActionListener(this);
        closeButton.addActionListener(this);

        selectFileButton.setFocusable(false);
        showImageButton.setFocusable(false);
        brightnessButton.setFocusable(false);
        grayscaleButton.setFocusable(false);
        resizeButton.setFocusable(false);
        closeButton.setFocusable(false);

        //Setting the color of buttons
        selectFileButton.setBackground(Color.LIGHT_GRAY);
        showImageButton.setBackground(Color.LIGHT_GRAY);
        brightnessButton.setBackground(Color.LIGHT_GRAY);
        grayscaleButton.setBackground(Color.LIGHT_GRAY);
        resizeButton.setBackground(Color.LIGHT_GRAY);
        closeButton.setBackground(Color.LIGHT_GRAY);

        selectFileButton.setBorder(BorderFactory.createBevelBorder(0, Color.BLACK, Color.WHITE));
        showImageButton.setBorder(BorderFactory.createBevelBorder(0, Color.BLACK, Color.WHITE));
        brightnessButton.setBorder(BorderFactory.createBevelBorder(0, Color.BLACK, Color.WHITE));
        grayscaleButton.setBorder(BorderFactory.createBevelBorder(0, Color.BLACK, Color.WHITE));
        resizeButton.setBorder(BorderFactory.createBevelBorder(0, Color.BLACK, Color.WHITE));
        closeButton.setBorder(BorderFactory.createBevelBorder(0, Color.BLACK, Color.WHITE));


        // Adding all buttons to Grid panel(buttonsPanel)
        buttonsPanel.add(this.selectFileButton);
        buttonsPanel.add(this.showImageButton);
        buttonsPanel.add(this.brightnessButton);
        buttonsPanel.add(this.grayscaleButton);
        buttonsPanel.add(this.resizeButton);
        buttonsPanel.add(this.closeButton);


        // add Grid panel that contains 6 buttons to main panel
        mainPanel.add(buttonsPanel);

        // add main panel to our frame
        this.add(mainPanel);
    }

    public void resizePanel(){
        JPanel resizePanel = new JPanel();
        resizePanel.setLayout(null);

        resizePanel.setBackground(Color.LIGHT_GRAY);

        JLabel label = new JLabel("Resize Section");
        JLabel width = new JLabel("Width:");
        JLabel height = new JLabel("Height:");

        label.setBounds(300, 25, 100, 30);
        width.setBounds(200, 75, 100, 30);
        height.setBounds(200, 125, 100, 30);

        widthTextField = new JTextField();
        heightTextField = new JTextField();

        widthTextField.setBounds(300,75, 200, 25);
        heightTextField.setBounds(300,125, 200, 25);

        showResizeButton = new JButton("Result");
        backButton = new JButton("Back");

        backButton.setBounds(100, 200, 150, 30);
        showResizeButton.setBounds(500, 200, 150, 30);

        backButton.setFocusable(false);
        showResizeButton.setFocusable(false);

        backButton.setBackground(Color.WHITE);
        showResizeButton.setBackground(Color.WHITE);

        backButton.addActionListener(this);
        showResizeButton.addActionListener(this);

        backButton.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
        showResizeButton.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));

        //Adding components to the resize panel
        resizePanel.add(label);
        resizePanel.add(width);
        resizePanel.add(widthTextField);
        resizePanel.add(height);
        resizePanel.add(heightTextField);
        resizePanel.add(backButton);
        resizePanel.add(showResizeButton);

        this.add(resizePanel);
    }
    public void brightnessPanel(){
        JPanel brightnessPanel = new JPanel();
        brightnessPanel.setBackground(Color.LIGHT_GRAY);
        brightnessPanel.setLayout(null);

        JLabel label1 = new JLabel("Enter a number to determine brightness:");
        JLabel label2 = new JLabel("(must be between 0 and 1)");

        label1.setBounds(70, 80, 250, 25);
        label2.setBounds(100, 110, 150, 25);

        showBrightnessButton = new JButton("Result");
        showBrightnessButton.setFocusable(false);
        showBrightnessButton.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
        showBrightnessButton.addActionListener(this);
        showBrightnessButton.setBackground(Color.WHITE);

        backButton = new JButton("Back");
        backButton.setFocusable(false);
        backButton.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
        backButton.addActionListener(this);
        backButton.setBackground(Color.WHITE);

        brightnessTextField = new JTextField();

        brightnessTextField.setBounds(320, 90, 175, 30);
        backButton.setBounds(125, 150, 100, 30);
        showBrightnessButton.setBounds(500, 150, 100, 30);

        //Adding components to the brightnessPanel
        brightnessPanel.add(label1);
        brightnessPanel.add(label2);
        brightnessPanel.add(backButton);
        brightnessPanel.add(showBrightnessButton);
        brightnessPanel.add(brightnessTextField);


        this.add(brightnessPanel);
    }
    public void fileWarningPanel(){
        JPanel fileWarningPanel = new JPanel();
        fileWarningPanel.setBackground(Color.LIGHT_GRAY);
        fileWarningPanel.setLayout(null);

        JLabel warning1 = new JLabel("NO FILE FOUND");
        JLabel warning2 = new JLabel("Please select an image and try again");

        warning1.setBounds(300, 50, 200, 50);
        warning2.setBounds(250, 100, 300, 50);

        backButton = new JButton("Back");
        backButton.setBounds(275, 200, 150, 30);
        backButton.setFocusable(false);
        backButton.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
        backButton.addActionListener(this);
        backButton.setBackground(Color.WHITE);


        fileWarningPanel.add(warning1);
        fileWarningPanel.add(warning2);
        fileWarningPanel.add(backButton);

        this.add(fileWarningPanel);
    }
    public void inputWarningPanel(){
        JPanel inputWarningPanel = new JPanel();
        inputWarningPanel.setBackground(Color.LIGHT_GRAY);
        inputWarningPanel.setLayout(null);

        JLabel warning = new JLabel("Enter a valid number please");
        warning.setBounds(265, 100, 250, 25);

        backButton = new JButton("Back");
        backButton.setBounds(275, 200, 150, 30);
        backButton.setFocusable(false);
        backButton.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
        backButton.addActionListener(this);
        backButton.setBackground(Color.WHITE);

        inputWarningPanel.add(warning);
        inputWarningPanel.add(backButton);

        this.add(inputWarningPanel);
    }

    public void chooseFileImage(){
        try{
            fileChooser.setAcceptAllFileFilterUsed(false);
            fileChooser.setDialogTitle("Select an image");
            //Adding filter for choosing file
            FileNameExtensionFilter filter = new FileNameExtensionFilter("Only .jpg and .png files", "jpg","png");
            fileChooser.addChoosableFileFilter(filter);

            int option = fileChooser.showOpenDialog(this);
            if(option == JFileChooser.APPROVE_OPTION)
                file = fileChooser.getSelectedFile();
        }
        //Because the file path may be wrong(null actually)
        catch (NullPointerException e){
            System.out.println("NO PATH FOUND");
            System.out.println("Please Enter new path:");
            Scanner scan = new Scanner(System.in);
            String path = scan.nextLine();
            this.filePath = path;
        }
    }
    public void showOriginalImage(){
        JFrame tempFrame = new JFrame();
        JPanel tempPanel = new JPanel();
        tempPanel.setSize(1800, 1000);

        tempFrame.setTitle("Image Viewer");
        tempFrame.setSize(1800, 1000);
        tempFrame.setVisible(true);
        tempFrame.setResizable(true);


        ImageIcon imageIcon = new ImageIcon(new ImageIcon(String.valueOf(file)).getImage());
        JLabel imageLabel = new JLabel();
        imageLabel.setIcon(imageIcon);

        tempPanel.add(imageLabel);
        tempFrame.add(tempPanel);

        if(file==null){
            tempFrame.setVisible(false);
            this.getContentPane().removeAll();
            this.fileWarningPanel();
            this.revalidate();
            this.repaint();
        }
    }

    public void grayScaleImage() {
        JFrame tempFrame = new JFrame();
        JPanel tempPanel = new JPanel();

        tempPanel.setSize(1800, 1000);
        tempFrame.setTitle("Image Viewer");
        tempFrame.setSize(1800, 1000);
        tempFrame.setVisible(true);
        tempFrame.setResizable(true);

        try{
            BufferedImage image = ImageIO.read(file);
            BufferedImage grayImage = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_BYTE_GRAY);
            Graphics g = grayImage.getGraphics();
            g.drawImage(image, 0, 0, null);
            g.dispose();

            ImageIcon imageIcon = new ImageIcon(grayImage);
            JLabel imageLabel = new JLabel();
            imageLabel.setIcon(imageIcon);

            tempPanel.add(imageLabel);
        }
        //for both IOException & IllegalArgumentException
        catch (Exception e){
            tempFrame.setVisible(false);
            this.getContentPane().removeAll();
            this.fileWarningPanel();
            this.revalidate();
            this.repaint();
        }

        tempFrame.add(tempPanel);

    }

    public void showResizeImage(int w, int h){
        JFrame tempFrame = new JFrame();
        JPanel tempPanel = new JPanel();

        ImageIcon imageIcon = new ImageIcon(new ImageIcon(String.valueOf(file)).getImage().getScaledInstance(w, h, Image.SCALE_DEFAULT));
        JLabel imageLabel = new JLabel();
        imageLabel.setIcon(imageIcon);

        tempPanel.add(imageLabel);

        tempPanel.setSize(1800, 1000);
        tempFrame.setTitle("Image Viewer");
        tempFrame.setSize(1800, 1000);
        tempFrame.setVisible(true);
        tempFrame.setResizable(true);
        tempFrame.add(tempPanel);

        if(file==null){
            tempFrame.setVisible(false);
            this.getContentPane().removeAll();
            this.fileWarningPanel();
            this.revalidate();
            this.repaint();
        }


    }
    public void showBrightnessImage(float f){
        JFrame tempFrame = new JFrame();
        JPanel tempPanel = new JPanel();

        tempPanel.setSize(1800, 1000);
        tempFrame.setTitle("Image Viewer");
        tempFrame.setSize(1800, 1000);
        tempFrame.setVisible(true);
        tempFrame.setResizable(true);

        try{

            BufferedImage image = ImageIO.read(file);

            for(int x = 0; x < image.getWidth(); x++){
                for(int y = 0; y < image.getHeight(); y++){
                    int rgb = image.getRGB(x,y); //getting the color of each pixel
                /*
                in the below code we move each component of ARGB format (alpha, red, green,blue)
                to the least significant 8 bits (the rightmost 8 bits) of the integer by the help of >> operator
                and then isolating each component by (& 0xFF)and putting them in individual variables
                */
                    int transparency = (rgb >> 24) & 0xFF;
                    int red = (rgb >> 16) & 0xFF;
                    int green = (rgb >> 8) & 0xFF;
                    int blue = rgb & 0xFF;

                    //Adjusting brightness
                    red = (int) (red * brightenFactor);
                    green = (int) (green * brightenFactor);
                    blue = (int) (blue * brightenFactor);

                    //updating pixel values
                    int newRGB = (transparency << 24) | (red << 16) | (green << 8) | blue;
                    image.setRGB(x , y, newRGB);
                }
            }
            ImageIcon imageIcon = new ImageIcon(image);
            JLabel imageLabel = new JLabel();
            imageLabel.setIcon(imageIcon);

            tempPanel.add(imageLabel);

            tempFrame.add(tempPanel);
        }
        //for both IOException & IllegalArgumentException
        catch(Exception e){
            tempFrame.setVisible(false);
            this.getContentPane().removeAll();
            this.fileWarningPanel();
            this.revalidate();
            this.repaint();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==resizeButton){
            this.getContentPane().removeAll();
            this.resizePanel();
            this.revalidate();
            this.repaint();
        }else if(e.getSource()== showImageButton){
            showOriginalImage();
        }else if(e.getSource()==grayscaleButton){
            grayScaleImage();
        }else if(e.getSource()== showResizeButton){
            try{
                this.w = Integer.parseInt(widthTextField.getText());
                this.h = Integer.parseInt(heightTextField.getText());
                widthTextField.setText("");
                heightTextField.setText("");
                showResizeImage(w, h);
            }
            catch (NumberFormatException exception){
                this.getContentPane().removeAll();
                this.inputWarningPanel();
                this.revalidate();
                this.repaint();
            }
        }else if(e.getSource()==brightnessButton){
            this.getContentPane().removeAll();
            this.brightnessPanel();
            this.revalidate();
            this.repaint();

        }else if(e.getSource()== showBrightnessButton){
            try{
                float brightness = Float.parseFloat(brightnessTextField.getText());
                if(brightness >= 0 && brightness <= 1){
                    brightenFactor = brightness;
                    brightnessTextField.setText("");
                    showBrightnessImage(brightenFactor);
                }
                else{
                    this.getContentPane().removeAll();
                    this.inputWarningPanel();
                    this.revalidate();
                    this.repaint();
                }
            }
            catch (NumberFormatException exception){
                this.getContentPane().removeAll();
                this.inputWarningPanel();
                this.revalidate();
                this.repaint();
            }

        }else if(e.getSource()== selectFileButton){
            chooseFileImage();
        }else if(e.getSource()==closeButton){
            this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
        }
        else if(e.getSource()==backButton){
            this.getContentPane().removeAll();
            this.mainPanel();
            this.revalidate();
            this.repaint();
        }
    }
}