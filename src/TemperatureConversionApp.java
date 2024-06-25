import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class TemperatureConversionApp {
      private JFrame frame;
      private JTextField inputField;
      private JComboBox<String> fromUnit;
      private JComboBox<String> toUnit;
      private JLabel resultLabel;
      private TemperatureConverter converter;
  
      public TemperatureConversionApp() {
          converter = new TemperatureConverter();
          initialize();
      }
  
      private void initialize() {
          frame = new JFrame("Temperature Conversion System");
          frame.setBounds(100, 100, 400, 300);
          frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          frame.getContentPane().setLayout(null);
  
          JLabel lblEnterValue = new JLabel("Enter Temperature:");
          lblEnterValue.setBounds(10, 10, 150, 25);
          frame.getContentPane().add(lblEnterValue);
  
          inputField = new JTextField();
          inputField.setBounds(170, 10, 150, 25);
          frame.getContentPane().add(inputField);
          inputField.setColumns(10);
  
          JLabel lblFromUnit = new JLabel("From Unit:");
          lblFromUnit.setBounds(10, 50, 150, 25);
          frame.getContentPane().add(lblFromUnit);
  
          fromUnit = new JComboBox<>(new String[]{"Celsius", "Fahrenheit", "Kelvin"});
          fromUnit.setBounds(170, 50, 150, 25);
          frame.getContentPane().add(fromUnit);
  
          JLabel lblToUnit = new JLabel("To Unit:");
          lblToUnit.setBounds(10, 90, 150, 25);
          frame.getContentPane().add(lblToUnit);
  
          toUnit = new JComboBox<>(new String[]{"Celsius", "Fahrenheit", "Kelvin"});
          toUnit.setBounds(170,90, 150, 25);
          frame.getContentPane().add(toUnit);
  
          JButton convertButton = new JButton("Convert");
          convertButton.setBounds(130, 130, 100, 25);
          frame.getContentPane().add(convertButton);
  
          resultLabel = new JLabel("Result: ");
          resultLabel.setBounds(10, 170, 350, 25);
          frame.getContentPane().add(resultLabel);
  
          convertButton.addActionListener(new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent e) {
                  convertTemperature();
              }
          });
  
          frame.setVisible(true);
      }
  
      private void convertTemperature() {
          try {
              double inputValue = Double.parseDouble(inputField.getText());
              String from = (String) fromUnit.getSelectedItem();
              String to = (String) toUnit.getSelectedItem();
              double result = 0;
  
              if (from.equals("Celsius")) {
                  if (to.equals("Fahrenheit")) {
                      result = converter.celsiusToFahrenheit(inputValue);
                  } else if (to.equals("Kelvin")) {
                      result = converter.celsiusToKelvin(inputValue);
                  } else {
                      result = inputValue;
                  }
              } else if (from.equals("Fahrenheit")) {
                  if (to.equals("Celsius")) {
                      result = converter.fahrenheitToCelsius(inputValue);
                  } else if (to.equals("Kelvin")) {
                      result = converter.fahrenheitToKelvin(inputValue);
                  } else {
                      result = inputValue;
                  }
              } else if (from.equals("Kelvin")) {
                  if (to.equals("Celsius")) {
                      result = converter.kelvinToCelsius(inputValue);
                  } else if (to.equals("Fahrenheit")) {
                      result = converter.kelvinToFahrenheit(inputValue);
                  } else {
                      result = inputValue;
                  }
              }
  
              resultLabel.setText("Result: " + result + " " + to);
          } catch (NumberFormatException ex) {
              JOptionPane.showMessageDialog(frame, "Please enter a valid number.", "Error", JOptionPane.ERROR_MESSAGE);
          }
      }
  
      public static void main(String[] args) {
          new TemperatureConversionApp();
      }
    }