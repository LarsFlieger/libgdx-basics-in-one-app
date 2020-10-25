package com.michael.javafrank;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.*;

public class Tutorial extends ApplicationAdapter {
	private SpriteBatch batch;
	private Texture texture;
	private TextureAtlas atlas;
	private TextureRegion pagerImage;
	private TextureRegion telfonImage;

	private Sprite sprite;
	private Sprite secondSprite;

	private BitmapFont font;

	private OrthographicCamera camera;

	private final int VIEWPORT_WIDTH = 10;

	@Override
	public void create () {
		Gdx.app.log("Info", Gdx.graphics.getWidth() + " x " + Gdx.graphics.getHeight());
		Gdx.app.log("Platform", "" + Gdx.app.getType());
		Gdx.app.log("Version", "" + Gdx.app.getVersion());
		Gdx.app.log("Density", "" + Gdx.graphics.getDensity());

		batch = new SpriteBatch();

		atlas = new TextureAtlas(Gdx.files.internal("atlas.atlas"));
		for(Texture texture : atlas.getTextures()) {
			texture.setFilter(Texture.TextureFilter.Nearest, Texture.TextureFilter.Nearest);
		}

		pagerImage = atlas.findRegion("pager");
		telfonImage = atlas.findRegion("telefon");

		Pixmap pixmap = createPixmap();
		texture = new Texture(pixmap);
		pixmap.dispose();
		texture.setFilter(Texture.TextureFilter.Nearest, Texture.TextureFilter.Nearest);


		sprite = new Sprite(pagerImage);
		sprite.setPosition(1, 1);
		sprite.setSize(2, 2);
		sprite.setOrigin(1, 1);
		sprite.setRotation(0);


		secondSprite = new Sprite(telfonImage);
		secondSprite.setPosition(1, 1);
		secondSprite.setSize(2, 2);

		font = new BitmapFont(Gdx.files.internal("fonts/font.fnt"));

		camera = new OrthographicCamera(VIEWPORT_WIDTH, VIEWPORT_WIDTH * Gdx.graphics.getHeight()/(float)Gdx.graphics.getWidth());
		camera.position.set(camera.viewportWidth/2f, camera.viewportHeight/2f, 0);
		camera.update();
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
	float i = 0;

	@Override
	public void render () {
		Gdx.app.log("FPS", "" + Gdx.graphics.getFramesPerSecond());
		Gdx.app.log("Delta Time", "" + Gdx.graphics.getDeltaTime());

		Gdx.gl.glClearColor(0, 0, 0.2f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		batch.setProjectionMatrix(camera.combined);

		camera.position.set(i -= 0.01f, camera.viewportHeight/2f, 0);
		camera.update();

		batch.begin();
		sprite.draw(batch);
		secondSprite.draw(batch);
		font.setColor(1,1,1,1);
		font.getData().setScale(0.02f);
		GlyphLayout layout = new GlyphLayout(font, "Hello!");
		font.draw(batch, layout, 0, layout.height);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		atlas.dispose();
	}

	@Override
	public void pause() {
	}


	@Override
	public void resume() {
	}

	@Override
	public void resize(int width, int height) {
		camera.viewportHeight = VIEWPORT_WIDTH * height/(float)width;
		camera.update();
	}
}
