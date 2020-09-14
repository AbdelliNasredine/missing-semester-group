const gulp = require("gulp");
const sass = require("gulp-sass");
const bundle_js = require("gulp-uglify");
const browserSync = require("browser-sync").create();
sass.compiler = require("node-sass");

const styles_src = "./scss/**/*.scss";
const styles_dist = "./dist/css";
const js_src = "./js/**/*.js";
const js_dist = "./dist/js";

function style() {
  return gulp
    .src(styles_src)
    .pipe(sass().on("error", sass.logError))
    .pipe(gulp.dest(styles_dist))
    .pipe(browserSync.stream());
}

function bundleJs() {
  return gulp
    .src(js_src)
    .pipe(bundle_js())
    .pipe(gulp.dest(js_dist))
    .pipe(browserSync.stream());
}

function watch() {
  browserSync.init({
    server: {
      baseDir: "./",
    },
  });
  gulp.watch(styles_src, style);
  gulp.watch(js_src, bundleJs);
  gulp.watch("./**/*.html").on("change", browserSync.reload);
}

exports.js = bundleJs;
exports.style = style;
exports.watch = watch;
