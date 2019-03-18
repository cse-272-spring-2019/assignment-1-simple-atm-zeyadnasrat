import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Transaction {
	
	
	Long Balance =(long)0 ;
	Scene scene3 ;
	MainMenu mainmenu ;
	Stage stage ;
	ArrayList<String> history;
	
	public Transaction(Stage primaryStage) {
		this.stage=primaryStage ;
	}


	
	public void depositWithdrawlScene3(){
   
	Label enter = new Label("Enter the amount you want to deposit/withdrawl :") ;
	TextField depositamount = new TextField();
	Button enterButton = new Button("deposit") ;
	Button withdrawlButton = new Button("withdrawl") ;
	Button backButton = new Button("back") ;
	Label showmoney = new Label() ;
	
	GridPane grid = new GridPane() ;
	grid.add(enter, 0, 0);
	grid.add(depositamount , 0, 1);
	grid.add(enterButton, 0, 2);
	grid.add(withdrawlButton, 0, 3);
	grid.add(backButton, 0, 4);
	grid.add(showmoney, 0, 5);
	
	enterButton.setOnAction(new EventHandler<ActionEvent>() {
		 public void handle (ActionEvent event)
		    {
	
	String input = depositamount.getText();
	Long x = parseLong(input);
	Balance = Balance + x ;
	 
	 showmoney.setText("   You have deposited  "+ Balance +" succesfully");
		    }
		 
	}) ;
	
	
	withdrawlButton.setOnAction(new EventHandler<ActionEvent>() {
		 public void handle (ActionEvent event)
		    {
			 String input = depositamount.getText();
				Long x = parseLong(input);
				if(Balance>=x)
				{Balance = Balance - x ;
				 
				 showmoney.setText("   You have withdrawed  "+ x +" succesfully");
				 }
				else { showmoney.setText("You don't have enough balance"); }
				
			 
			 
		    }
		
	
	});
	
	
	
	backButton.setOnAction(new EventHandler<ActionEvent>() {
		
		 public void handle (ActionEvent event)
		    {
			 stage.setScene(mainmenu.getScene2());
	        
		    } 
	});
			 
			 
	 scene3 = new Scene(grid,400,400) ;
	 } 
	
	 
	public  Long parseLong(String text) {
		Long x =(long) 0;
		int j =-1;
		for(int i = text.length()-1; i >= 0; i--)
		{	
			j++;
			x = (long)(x + (text.charAt(i) - '0') * Math.pow(10, j));
		}
		return x;
	}
	public Scene getScene3() {
		return scene3;
	}

	public MainMenu getMainmenu() {
		return mainmenu;
	}

	public void setMainmenu(MainMenu mainmenu) {
		this.mainmenu = mainmenu;
	}
	
	public double getBalance()
	   {  
		return this.Balance ;
		}
	public ArrayList<String> getHistory() {
		return history;
	}
	public void setHistory(ArrayList<String> history) {
		this.history = history;
	}
	 
 }