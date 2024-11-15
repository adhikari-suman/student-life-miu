import { Token } from "./MyDecorator.js";
import { Student } from "./Student.js";

@Token({
    course: "MWA",
    canProgram: false,
})
export class DE_Student extends Student {

}