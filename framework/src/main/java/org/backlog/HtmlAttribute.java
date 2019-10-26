//package org.backlog;
//
//import java.io.File;
//
//public enum HtmlAttribute {
//    private void deleteRecursively(File file) {
//        if (file.isDirectory()) {
//            File[] entries = file.listFiles();
//            if (entries != null) {
//                for (File entry : entries) {
//                    deleteRecursively(entry);
//                }
//            }
//        }
//        if (file.exists()) {
//            if (!file.delete()) {
//                logger.warn("Cannot delete %s", file.getPath());
//            } else {
//                logger.debug("Deleted file %s", file.getPath());
//            }
//        }
//    }
//    background,
//    background_attachment,
//    background_color,
//    background_image,
//    background_position,
//    background_repeat,
//    border,
//    border_bottom,
//    border_bottom_color,
//    border_bottom_style,
//    border_bottom_width,
//    border_color,
//    border_left,
//    border_left_color,
//    border_left_style,
//    border_left_width,
//    border_right,
//    border_right_color,
//    border_right_style,
//    border_right_width,
//    border_style,
//    border_top,
//    border_top_color,
//    border_top_style,
//    border_top_width,
//    border_width,
//    clear,
//    clip,
//    color,
//    cursor,
//    display,
//    filter,
//    float,
//    font,
//    font_family,
//    font_size,
//    font_variant,
//    font_weight,
//    height,
//    left,
//    letter_spacing,
//    line_height,
//    list_style,
//    list_style_image,
//    list_style_position,
//    list_style_type,
//    margin,
//    margin_bottom,
//    margin_left,
//    margin_right,
//    margin_top,
//    overflow,
//    padding,
//    padding_bottom,
//    padding_left,
//    padding_right,
//    padding_top,
//    page_break_after,
//    page_break_before,
//    position,
//    stroke_dasharray,
//    stroke_dashoffset,
//    stroke_width,
//    text_align,
//    text_decoration,
//    text_indent,
//    text_transform,
//    top,
//    vertical_align,
//    visibility,
//    width,
//    z_index,
//
//    private String fullName;
//
//    HtmlAttribute(String fullName) {
//        this.fullName = fullName;
//    }
//
//    public String getFullName() {
//        return fullName;
//    }
//}
