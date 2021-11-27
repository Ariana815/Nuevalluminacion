# Nuevalluminacion
Creación de un cubo con algunos efectos 

El siguiente proyecto trata más que nada de la manera en cómo se dan algunos efectos como de iluminación, el cambio de fondo

Empezamos con las librerías que se utilizaron 

![WhatsApp Image 2021-11-26 at 8 35 08 PM](https://user-images.githubusercontent.com/71719625/143667403-785531d2-d21a-4850-8700-06d5ddc27de1.jpeg)

Explicamos las librerías más notables

Las librerías se encargaban del puntero del recurso en una animación, ayudan a crear una textura a la figura en este caso al cubo, el manejo de eventos entre otras, son las nuevas funciones que se implementaron con ayuda de las librerías. 

![WhatsApp Image 2021-11-26 at 8 35 10 PM](https://user-images.githubusercontent.com/71719625/143667675-8d3e9215-c57b-4709-8294-619b57f8edb7.jpeg)

Algunas de las funciones que maneja el código es que se cambiará el color de fondo, y cambiando algunos valores del código ocurrirá lo siguiente:

![WhatsApp Image 2021-11-26 at 8 35 09 PM (1)](https://user-images.githubusercontent.com/71719625/143667735-a49f822d-3b53-4050-92b0-2922e0414b6c.jpeg)

Al modificar, cambiamos el color de fondo cambia de esta manera

![WhatsApp Image 2021-11-26 at 8 35 09 PM](https://user-images.githubusercontent.com/71719625/143667742-4350ed9e-715a-43f7-a150-d1d739a28eeb.jpeg)

La parte inicial de este código se usa public void reshape(GLAutodrawable drawable, int x, int y, int width, int height) Este método es llamado por drawable durante el primer redibujado (repaint) y después de que el componente se redimensiona (resize).

![WhatsApp Image 2021-11-26 at 8 35 10 PM (1)](https://user-images.githubusercontent.com/71719625/143667794-776dd568-5e36-4de0-9ff0-7bcaa033f254.jpeg)

El método public void display(GLAutoDrawable drawable) describe que el color de borrado es el color: negro (Black) sin ser traslucido (alpha es 1), especificado para RGBA.

![WhatsApp Image 2021-11-26 at 8 35 11 PM](https://user-images.githubusercontent.com/71719625/143667810-c5b74f44-b8de-4108-be9e-29bdba8c9af5.jpeg)

La parte que se maneja la iluminación del cubo, se expresa  mediante las matrices, las cuales se crearan a partir del tipo de luz que se presente, ya sea ambiente, difusa o especular al igual que la cantidad de brillo que se le  otorgue. 

![WhatsApp Image 2021-11-26 at 8 35 11 PM (1)](https://user-images.githubusercontent.com/71719625/143667845-55c30545-9553-4005-99a3-773cc6b3e6e9.jpeg)


