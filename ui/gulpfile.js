const gulp = require("gulp");
const sass = require("gulp-sass");
const browserSync = require("browser-sync").create();
sass.compiler = require("node-sass");

const styles_src = "./scss/**/*.scss";
const styles_dist = "./dist/css";

function style() {
  return gulp
    .src(styles_src)
    .pipe(sass().on("error", sass.logError))
    .pipe(gulp.dest(styles_dist))
    .pipe(browserSync.stream());
}

function watch() {
  browserSync.init({
    server: {
      baseDir: "./",
    },
  });
  gulp.watch(styles_src, style);
  gulp.watch("./**/*.html").on("change", browserSync.reload);
}

exports.style = style;
exports.watch = watch;
