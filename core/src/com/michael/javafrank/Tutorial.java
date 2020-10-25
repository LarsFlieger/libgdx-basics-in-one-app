package com.michael.javafrank;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Tutorial extends ApplicationAdapter {
	private SpriteBatch batch;
	private Texture texture;
	private Sprite sprite;

	@Override
	public void create () {
		Gdx.app.log("Info", Gdx.graphics.getWidth() + " x " + Gdx.graphics.getHeight());
		Gdx.app.log("Platform", "" + Gdx.app.getType());
		Gdx.app.log("Version", "" + Gdx.app.getVersion());
		Gdx.app.log("Density", "" + Gdx.graphics.getDensity());

		batch = new SpriteBatch();
		Pixmap pixmap = createPixmap();
		texture = new Texture(pixmap);
		pixmap.dispose();
		texture.setFilter(Texture.TextureFilter.Nearest, Texture.TextureFilter.Nearest);


		sprite = new Sprite(texture);
		sprite.setPosition(200, 200);
		sprite.setSize(128 * 4, 128 * 4);
		sprite.setOrigin(128 * 2, 128 * 2);
		sprite.setRotation(0);
	}

	private Pixmap createPixmap() {
		Pixmap pixmap = new Pixmap(20, 20, Pixmap.Format.RGBA8888);

		pixmap.setColor(0.2f, 0.2f, 0.5f, 1);
		pixmap.fill();

		pixmap.setColor(0,1,0,1);
		for(int i = 0; i < 20; i++) {
			pixmap.drawPixel(i, 0);
			pixmap.drawPixel(0, i);
			pixmap.drawPixel(i, i);
		}

		return pixmap;
	}

	@Override
	public void render () {
		Gdx.app.log("FPS", "" + Gdx.graphics.getFramesPerSecond());
		Gdx.app.log("Delta Time", "" + Gdx.graphics.getDeltaTime());

		Gdx.gl.glClearColor(0, 0, 0.2f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		batch.begin();
		sprite.draw(batch);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}

	@Override
	public void pause() {
	}


	@Override
	public void resume() {
	}

	@Override
	public void resize(int width, int height) {
	}
}
