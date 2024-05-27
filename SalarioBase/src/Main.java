import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Cálculo de Salário Base");

        // GridPane layout
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(8);
        grid.setHgap(10);

        // Salário Base Label
        Label salarioBaseLabel = new Label("Salário Base:");
        GridPane.setConstraints(salarioBaseLabel, 0, 0);

        // Salário Base Input
        TextField salarioBaseInput = new TextField();
        salarioBaseInput.setPromptText("Digite o salário base");
        GridPane.setConstraints(salarioBaseInput, 1, 0);

        // Botão Calcular
        Button calcularButton = new Button("Calcular");
        GridPane.setConstraints(calcularButton, 1, 1);

        // Label para exibir o resultado
        Label resultadoLabel = new Label();
        GridPane.setConstraints(resultadoLabel, 1, 2);

        // Ação do botão Calcular
        calcularButton.setOnAction(e -> {
            double salarioBase = Double.parseDouble(salarioBaseInput.getText());
            double gratificacao = salarioBase * 0.05;
            double imposto = (salarioBase + gratificacao) * 0.07;
            double salarioReceber = salarioBase + gratificacao - imposto;

            resultadoLabel.setText(String.format("Salário a receber: R$ %.2f", salarioReceber));
        });

        // Adicionar todos os componentes ao grid
        grid.getChildren().addAll(salarioBaseLabel, salarioBaseInput, calcularButton, resultadoLabel);

        // Configurar a cena
        Scene scene = new Scene(grid, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
