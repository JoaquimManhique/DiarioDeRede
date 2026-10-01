# Diário de Rede (Network Diary)

## Informações do Grupo
* **Turma:** 3L6LASIR3T
* **Tema:** Tema C — Diário de Rede
* **Integrantes do Grupo:**
  1. Karen Francisco - 202401372
  2. Leticia Matola - 202400472
  3. Zelfan Cau - 202302142


## Descrição da Aplicação
A aplicação **Diário de Rede** permite monitorizar em tempo real o estado da ligação de rede do dispositivo (identificando se está conectado via Wi-Fi, Dados Móveis ou Sem Ligação). Além disso, dispõe de uma funcionalidade de diário onde o utilizador pode registar notas manuais sobre a qualidade ou ocorrências da rede, sendo cada apontamento carimbado automaticamente com a data e hora do registo.

## Funcionalidades Implementadas
* Identificação em tempo real do estado da rede (Wi-Fi / Dados Móveis / Sem Ligação).
* Navegação fluida entre ecrãs através de `Intents`.
* Inserção de notas manuais de utilizador.
* Registo automático de data e hora para cada nota guardada.
* Interface desenhada inteiramente com `ConstraintLayout`.

## Tecnologias Utilizadas
* Linguagem: Java
* Ambiente de Desenvolvimento: Android Studio
* Componentes visuais: ConstraintLayout, ListView, Button, EditText, TextView

## Permissões Utilizadas
* `android.permission.ACCESS_NETWORK_STATE` (Para ler o estado atual da ligação à internet).
* `android.permission.INTERNET` (Para validar conectividade).

## Instruções para Executar o Projeto
1. Clonar ou descarregar o repositório para o computador.
2. Abrir o Android Studio.
3. Selecionar **Open an Existing Project** e apontar para a pasta do projeto.
4. Sincronizar o projeto com o Gradle (`Sync Project with Gradle Files`).
5. Executar a aplicação num Emulador Android ou num dispositivo físico com suporte a Wi-Fi/Dados Móveis.
