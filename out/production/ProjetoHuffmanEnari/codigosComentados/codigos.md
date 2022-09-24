    public Map<Character, Integer> frequenciaTexto (String line, Map<Character, Integer> tabelaFreq , int counter, int i, int j) {
        StringBuilder jaEncontrados = new StringBuilder();
        int tamanhoDaFrase = line.split("").length;

        if(i < tamanhoDaFrase ){
            if(j < tamanhoDaFrase ){
                if(line.charAt(i) == line.charAt(j)){
                    frequenciaTexto(line, tabelaFreq, counter + 1, i, j + 1);
                }else{
                    frequenciaTexto(line, tabelaFreq, counter , i, j + 1);
                }
            }else{
                char c = line.charAt(i);
                if (!jaEncontrados.toString().contains("" + c)) {
                    jaEncontrados.append(c);
                    tabelaFreq.put(c, counter);
                }
                frequenciaTexto(line, tabelaFreq, counter = 0, i + 1, j = 0);
            }
        }
        return tabelaFreq;
    }



'the quick brown fox jumps over the lazy dog this is a sample text that we will use when we build up a table we will only handle lower case letters and no punctuation symbols the frequency will of course not represent english but it is probably not that far off'
