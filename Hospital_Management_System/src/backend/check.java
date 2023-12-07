package backend;

import java.awt.Font;
import java.io.FileOutputStream;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class check {

	public static void main(String[] args) {
		try {
			String path="";
//			JFileChooser j=new JFileChooser();
//			j.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
//			int x=j.showSaveDialog(btnNewButton);
//			if(x==JFileChooser.APPROVE_OPTION)
//			{
//				path=j.getSelectedFile().getPath();
//			}
			Document doc=new Document();
            PdfWriter.getInstance(doc, new FileOutputStream(path+"abc1.pdf"));
            doc.open();
            //PdfPTable tbl=new PdfPTable(3);
            //tbl.addCell("First Name");
            //tbl.addCell("Last Name");
            //tbl.addCell("Mobile Number");
            doc.add(new Paragraph("Hello World",FontFactory.getFont(FontFactory.TIMES_BOLD,28,Font.BOLD,BaseColor.RED)));
            doc.add(new Paragraph("-----------------------"));
//            int col=table.getColumnCount();
            
            
 //           PdfPTable tbl=new PdfPTable(col);
//            int row=table.getRowCount();
//            tbl.addCell("ID");
//            tbl.addCell("Name");
//            tbl.addCell("E-mail");
//            //tbl.addCell("Password");
//            tbl.addCell("Number");
//            tbl.addCell("Gender");
//            tbl.addCell("Birthday");
//            tbl.addCell("Age");
//            tbl.addCell("Address");
//            System.out.println(col+"  "+row);//8 2
//            for(int i=0;i<row;i++)
//            {
//            	for(int k=0;k<col;k++)
//            	{
//            		String A=table.getValueAt(i,k).toString();
//            		System.out.println(A);
//            		tbl.addCell(A);
//            	}
//            	doc.add(tbl);
//            }
//            
//            
//            
//			doc.add(tbl);
			JOptionPane.showMessageDialog(null, "Pdf gnerated");
			doc.close();
			
			
		}catch(Exception e1) {
			System.out.println("Bill print"+e1);
		}
	}

}
