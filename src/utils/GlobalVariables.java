package utils;

public class GlobalVariables {
    public static final String LOCAL_ARQUIVO_ENTRADA = "ENTRADAS/";
    public static final String LOCAL_ARQUIVO_FINAL = "SAIDAS/";
    public static final String LOCAL_ARQUIVO_FINAL_RESULTADOS = LOCAL_ARQUIVO_FINAL + "RESULTADOS/";
    public static final String LOCAL_LOG = LOCAL_ARQUIVO_FINAL + "LOGS/";

    public static final String absolutePathProject = System.getProperty("user.dir") + "\\";
    public static final String absolutePathProjectArquivoEntrada = absolutePathProject + GlobalVariables.LOCAL_ARQUIVO_ENTRADA;
}
