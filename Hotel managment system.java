package com.mycompany.hospitalmanagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

class Patient {

    String name;
    int age;
    String gender;
    String disease;

    public Patient(String name, int age, String gender, String disease) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.disease = disease;
    }

    @Override
    public String toString() {
        return name + "\t" + age + "\t" + gender + "\t" + disease;
    }
}

public class HospitalManagement {

    private JFrame frame;
    private JTextField nameField, ageField, genderField, diseaseField, searchField;
    private JTextArea displayArea;
    private ArrayList<Patient> patients;

    public HospitalManagement() {
        frame = new JFrame("Hospital Management System");
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        patients = new ArrayList<>();

        JLabel nameLabel = new JLabel("Name:");
        nameField = new JTextField(20);
        JLabel ageLabel = new JLabel("Age:");
        ageField = new JTextField(5);
        JLabel genderLabel = new JLabel("Gender:");
        genderField = new JTextField(10);
        JLabel diseaseLabel = new JLabel("Disease:");
        diseaseField = new JTextField(20);
        JButton addButton = new JButton("Add Patient");
        JButton viewButton = new JButton("View All Patients");
        JButton searchButton = new JButton("Search");
        searchField = new JTextField(15);
        displayArea = new JTextArea(15, 40);
        displayArea.setEditable(false);

        frame.add(nameLabel);
        frame.add(nameField);
        frame.add(ageLabel);
        frame.add(ageField);
        frame.add(genderLabel);
        frame.add(genderField);
        frame.add(diseaseLabel);
        frame.add(diseaseField);
        frame.add(addButton);
        frame.add(viewButton);
        frame.add(new JLabel("Search by Name:"));
        frame.add(searchField);
        frame.add(searchButton);
        frame.add(new JScrollPane(displayArea));

        addButton.addActionListener(e -> addPatient());
        viewButton.addActionListener(e -> viewPatients());
        searchButton.addActionListener(e -> searchPatient());

        frame.setVisible(true);
    }

    private void addPatient() {
        try {
            String name = nameField.getText();
            int age = Integer.parseInt(ageField.getText());
            String gender = genderField.getText();
            String disease = diseaseField.getText();
            patients.add(new Patient(name, age, gender, disease));
            JOptionPane.showMessageDialog(frame, "Patient Added Successfully!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(frame, "Error Adding Patient!");
        }
    }

    private void viewPatients() {
        displayArea.setText("Name\tAge\tGender\tDisease\n");
        for (Patient p : patients) {
            displayArea.append(p + "\n");
        }
    }

    private void searchPatient() {
        String searchName = searchField.getText().toLowerCase();
        displayArea.setText("Name\tAge\tGender\tDisease\n");
        for (Patient p : patients) {
            if (p.name.toLowerCase().contains(searchName)) {
                displayArea.append(p + "\n");
            }
        }
    }

    public static void main(String[] args) {
        new HospitalManagement();
    }
}
