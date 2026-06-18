1. O que é uma View no Android Framework?
R_ Uma view é basicamente qualquer elemento que inserimos na tela, que podemos ver, tocar ou interagir.
Ex: TextView (texto), Button (botão), ImageView (foto), EditView (campo de texto)...
2. O que é um ViewGroup no contexto da interface Android?
R_ Um ViewGroup é um acaixa incisível que é usada para organizar, posicionar e agrupar outras Views dentro dele. Podemos dizer que ele define as regras de onde cada elemento deve ficar.
3. Qual é a função dos LayoutParams dentro de um ViewGroup?
R_ A função dos LayoutParams é ser o ajuste de tamanho e distância que a View pede para o seu layout "pai" --> (ViewGroup), sem isso o ViewGroup não saberia como organizar os elementos na tela.
4. Por que diferentes ViewGroups, como LinearLayout, ConstraintLayout e FrameLayout, utilizam subclasses específicas de LayoutParams?
R_ Porque cada tipo de layout organiza as coisas de um jeito completamente diferente, cada um possui suas regras.
Ex: FrameLayout --> oganizador simples (pilha) por isso só precisa saber se a View vai ficar no topo, centro ou embaixo.
Ex: LinearLayout --> organizador em fila, precisa saber se uma View deve crescer mais que as outras para preencher a tela.
Ex: ConstraintLayout --> organizador por amarras (elásticos), precisa saber qual lado da View está amarrado em qual parede, ou seja, se prendermos em todas ele fica no centro.

