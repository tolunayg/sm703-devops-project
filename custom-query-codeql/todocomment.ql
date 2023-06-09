/**
 * @id java/examples/todocomment
 * @name TODO comments
 * @description Finds comments containing the word "TODO"
 * @tags comment
 *       TODO
 */

import java

from Comment c
where c.getText().regexpMatch("(?si).*\\bTODO\\b.*")
select c