package org.yourorghere;

import com.sun.opengl.util.Animator;
import com.sun.opengl.util.GLUT;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLCanvas;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.glu.GLU;

public class NuevaIluminacion implements GLEventListener {
    //Matrices para las luces
    final float[] mat_ambiente = {0.2f, 0.2f, 0.2f, 1.0f};
    final float[] mat_difuso = {0.8f, 0.8f, 0.8f, 1.0f};
    final float[] mat_especular = {0.0f, 0.0f, 0.0f, 1.0f};
    final float[] mat_brillo = {10.0f};
    public static void main(String[] args) {
        Frame frame = new Frame("Simple JOGL Application");
        GLCanvas canvas = new GLCanvas();
        canvas.addGLEventListener(new NuevaIluminacion());
        frame.add(canvas);
        frame.setSize(640, 480);
        final Animator animator = new Animator(canvas);
        frame.addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                new Thread(new Runnable() {
                    public void run() {
                        animator.stop();
                        System.exit(0);
                    }
                }).start();
            }
        });
        // Center frame
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        animator.start();
    }

    public void init(GLAutoDrawable drawable) {
        GL gl = drawable.getGL(); // inicializa la variable GL

        gl.glClearColor(0.5f, 0.5f, 1.0f, 0.0f);

        // Parametros de la luz 0
        float[] luzAmbiente = {0.2f, 0.2f, 0.2f, 1.0f};
        float[] luzDifusa = {0.8f, 0.8f, 0.8f, 1.0f};
        float[] luzEspecular = {0.0f, 0.0f, 0.0f, 1.0f};
        float[] posicion = {1.0f, 1.0f, 1.0f, 1.0f};

        // Se setean los parámetros del ambiente
        gl.glLightfv(GL.GL_LIGHT0, GL.GL_AMBIENT, luzAmbiente, 0);
        gl.glLightfv(GL.GL_LIGHT0, GL.GL_DIFFUSE, luzDifusa, 0);
        gl.glLightfv(GL.GL_LIGHT0, GL.GL_SPECULAR, luzEspecular, 0);
        gl.glLightfv(GL.GL_LIGHT0, GL.GL_POSITION, posicion, 0);

        gl.glEnable(GL.GL_DEPTH_TEST); // Habilita el ocultamiento de superficies
        gl.glEnable(GL.GL_LIGHTING); // Habilita la iluminacion
        gl.glEnable(GL.GL_LIGHT0); // Habilita la luz 0 que previamente se habia seteado
    }

    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
        GL gl = drawable.getGL();
        GLU glu = new GLU();

        if (height == 0) {
            height = 1;
        }
        gl.glViewport(0, 0, width, height);
        gl.glMatrixMode(GL.GL_PROJECTION);
        gl.glLoadIdentity();
        if (width > height) {
            glu.gluPerspective(45.0f, width / height, 1, 150.0f);
        } else {
            glu.gluPerspective(45.0f, width / height, 1, 150.0f);
        }

        gl.glMatrixMode(GL.GL_MODELVIEW);
        gl.glLoadIdentity();
    }

    public void display(GLAutoDrawable drawable) {
        GL gl = drawable.getGL();
        GLU glu = new GLU();
        GLUT glut = new GLUT();

        // borra buffer y el z-buffer, rota el cubo y dibuja, intercambiando buffers
        gl.glClear(GL.GL_COLOR_BUFFER_BIT | GL.GL_DEPTH_BUFFER_BIT);
        gl.glLoadIdentity();

        glu.gluLookAt(0.0f, 0.0f, 5.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f);//Funcion de la camara
        //            posX, posY, posZ, MiraX,miraY,miraZ,arriX,ArriY,ArriZ

        // Superficie                Parametros del objeto
        gl.glMaterialfv(GL.GL_LEFT, GL.GL_AMBIENT, mat_ambiente, 0);//Luz Ambiente
        gl.glMaterialfv(GL.GL_LEFT, GL.GL_DIFFUSE, mat_difuso, 0);//Luz Difusa
        gl.glMaterialfv(GL.GL_LEFT, GL.GL_SPECULAR, mat_especular, 0);//Luz Espectacular
        gl.glMaterialfv(GL.GL_LEFT, GL.GL_SHININESS, mat_brillo,0);//Brillo
        gl.glPushMatrix();
            gl.glRotated(30, 1, 1, 0);
            glut.glutSolidCube(0.5f);
        gl.glPopMatrix();
        drawable.swapBuffers();
        gl.glFlush();
    }

    public void displayChanged(GLAutoDrawable drawable, boolean modeChanged, boolean deviceChanged) {
    }
}

