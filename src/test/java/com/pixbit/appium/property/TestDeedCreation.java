package com.pixbit.appium.property;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.apache.pdfbox.pdmodel.interactive.form.PDField;
import org.testng.annotations.Test;

public class TestDeedCreation {
	
	
	@Test
	 public void documentCreation() {
	        String inputFilePath = System.getProperty("user.dir")+"/src/test/java/com/pixbit/appium/property/SampleTitleDeed.pdf";
	        String outputFilePath = "/Users/vk14/Downloads/Docs_for_testing/Title_Deed/used_deed/titledeed_test_1.pdf";  

	        try {
	            // Load the sample PDF document
	            File file = new File(inputFilePath);
	            PDDocument document = PDDocument.load(file);

	            // Check if the PDF contains form fields
	            PDAcroForm acroForm = document.getDocumentCatalog().getAcroForm();

	            if (acroForm != null) {
	                // Example: Update the field "name" to "John Doe"
	                PDField nameField = acroForm.getField("91777/2023");  // The name of the field in the PDF
	                if (nameField != null) {
	                    nameField.setValue("654645/2011");
	                }

	                // Example: Update the field "email" to "john.doe@example.com"
	                PDField emailField = acroForm.getField("Collective 2.0 Tower A");
	                if (emailField != null) {
	                    emailField.setValue("Merec Real Estate");
	                }

	                // Example: Update the field "date" to "01-01-2024"
	                PDField dateField = acroForm.getField("1303");
	                if (dateField != null) {
	                    dateField.setValue("87876");
	                }

	                // Save the updated document to a new file
	                document.save(outputFilePath);
	                System.out.println("PDF updated and saved to " + outputFilePath);
	            } else {
	                System.out.println("No form fields found in the PDF.");
	            }

	            // Close the document
	            document.close();

	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }

}
