package org.fluentness.prototype;

import org.fluentness.GameApplication;
import org.fluentness.prototype.controller.GameController;
import org.fluentness.prototype.repository.EntityRepository;
import org.fluentness.prototype.repository.PlayerRepository;
import org.fluentness.prototype.repository.TerrainRepository;
import org.fluentness.prototype.view.GameView;
import org.fluentness.service.algebra.Algebra;
import org.fluentness.service.algebra.AlgebraImpl;
import org.fluentness.service.animator.Animator;
import org.fluentness.service.animator.AnimatorImpl;
import org.fluentness.service.configuration.Configuration;
import org.fluentness.service.display.Display;
import org.fluentness.service.display.GlfwDisplay;
import org.fluentness.service.loader.Loader;
import org.fluentness.service.loader.LoaderImpl;
import org.fluentness.service.log.JulLog;
import org.fluentness.service.log.Log;
import org.fluentness.service.looper.Looper;
import org.fluentness.service.looper.LooperImpl;
import org.fluentness.service.memory.Memory;
import org.fluentness.service.memory.MemoryImpl;
import org.fluentness.service.parser.MeshParser;
import org.fluentness.service.parser.TextureParser;
import org.fluentness.service.render.EntityRender;
import org.fluentness.service.render.TerrainRender;
import org.fluentness.service.shader.EntityShader;
import org.fluentness.service.shader.TerrainShader;

public class WorldGenerator extends GameApplication {

    public WorldGenerator(Looper looper, GameController controller) {
        super(looper, controller);
    }

    public static void main(String[] args) throws Exception {
        // example of manually instantiating and injecting dependencies instead of using ConstructorInjector
        // allowing us to create native-images with graalvm out of this prototype (no reflection is being used)
        Loader loader;
        Configuration configuration;
        TerrainRepository terrainRepository;
        Algebra algebra;
        Memory memory;
        Log log;
        Display display;
        EntityRepository entityRepository;
        PlayerRepository playerRepository;
        Animator animator;
        new WorldGenerator(
            new LooperImpl(
                display = new GlfwDisplay(
                    configuration = new org.fluentness.prototype.service.Configuration(),
                    log = new JulLog(configuration)
                ),
                new TerrainRender(
                    algebra = new AlgebraImpl(),
                    new TerrainShader(
                        memory = new MemoryImpl()
                    )
                ),
                new EntityRender(
                    algebra,
                    new EntityShader(
                        memory
                    )
                ),
                memory,
                animator = new AnimatorImpl()
            ),
            new GameController(
                new GameView(
                    terrainRepository = new TerrainRepository(
                        loader = new LoaderImpl(
                            configuration,
                            memory,
                            new MeshParser(
                                log
                            ),
                            new TextureParser(
                                log
                            )
                        )
                    ),
                    new EntityRepository(
                        loader,
                        terrainRepository
                    ),
                    playerRepository = new PlayerRepository(
                        loader
                    )
                ),
                display,
                animator,
                playerRepository,
                terrainRepository
            )
        ).run(args);
    }
}
